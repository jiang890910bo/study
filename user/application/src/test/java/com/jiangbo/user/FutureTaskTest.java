package com.jiangbo.user;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * FutureTaskTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/11/29
 */
@Slf4j
public class FutureTaskTest {

  //超时时间(ms)
  private static int TIME_OUT = 440;

  private static ExecutorService executorService = new ThreadPoolExecutor(2 * Runtime.getRuntime().availableProcessors(), 2 * Runtime.getRuntime().availableProcessors(), 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000),
    Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

  public static void main(String[] args) {


    List<ResponsePerson> resultPersonList = Lists.newArrayList();
    List<RequestPerson> requestParamList = new ArrayList<>();
    RequestPerson zsPerson = new RequestPerson("张三", 25);
    RequestPerson lsPerson = new RequestPerson("李四", 26);
    RequestPerson wuPerson = new RequestPerson("王五", 27);

    requestParamList.add(zsPerson);
    requestParamList.add(lsPerson);
    requestParamList.add(wuPerson);

    //业务操作
    businessWork(resultPersonList, requestParamList);

    executorService.shutdown();
    resultPersonList.forEach(person -> System.out.println(JSONObject.toJSONString(person)));
  }

  /**
   * 业务操作
   * @param resultPersonList
   * @param requestParamList
   */
  private static void businessWork(List<ResponsePerson> resultPersonList, List<RequestPerson> requestParamList) {
    long startTime = System.currentTimeMillis();
    List<Future<ResponsePerson>> futureList = new ArrayList<>();
    StopWatch stopWatch = new StopWatch("futureTask");
    stopWatch.start("并行执行时间");

    requestParamList.forEach(person -> {
      Callable<ResponsePerson> personCallable = () -> {

        //此处表示调用其他服务的接口操作
        int sleepTime = new Random().nextInt(9);
        Thread.sleep(sleepTime * 100);
        return new ResponsePerson("姓名：" + person.getName() + ", 年龄：" + person.getAge());
      };

      Future<ResponsePerson> future = executorService.submit(personCallable);
      futureList.add(future);
    });

    try {
      loopWithTimeOut(startTime);
      stopWatch.stop();
      System.out.println(stopWatch.prettyPrint());

      futureList.parallelStream().forEach(future -> {
        if (future.isDone()) {
          ResponsePerson responsePerson = null;
          try {
            responsePerson = future.get();
          } catch (InterruptedException e) {
            resultPersonList.add(new ResponsePerson("超时异常"));
            e.printStackTrace();
          } catch (ExecutionException e) {
            resultPersonList.add(new ResponsePerson("超时异常"));
            e.printStackTrace();
          }
          resultPersonList.add(responsePerson);
        } else {
          //规定时间仍未完成操作的直接取消任务
          future.cancel(Boolean.TRUE);
          resultPersonList.add(new ResponsePerson("超时异常"));
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 响应时间限制轮询
   * @param startTime
   */
  @SneakyThrows
  private static void loopWithTimeOut(long startTime) {
    if ((System.currentTimeMillis() - startTime) < TIME_OUT) {
      Thread.sleep(10);
      loopWithTimeOut(startTime);
    }
  }

  @Setter
  @Getter
  static class RequestPerson {

    RequestPerson(String name, Integer age) {
      this.name = name;
      this.age = age;
    }

    private String name;

    private Integer age;
  }

  @Setter
  @Getter
  @ToString
  static class ResponsePerson {

    ResponsePerson(String description) {
      this.description = description;
    }

    private String description;
  }
}
