package com.jiangbo.user;

import io.micrometer.core.instrument.util.NamedThreadFactory;
import io.netty.util.concurrent.RejectedExecutionHandlers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * MyTest
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/06/10
 * @Version 1.0.0
 */
public class MyTest implements Runnable{

  private static ThreadLocal<Long> countThreadLocal = new ThreadLocal<Long>(){
    @Override
    protected Long initialValue() {
      return 1L;
    }
  };
  private static ExecutorService threadPoolExecutor1 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程1"));
  private static ExecutorService threadPoolExecutor2 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程2"));
  private static ExecutorService threadPoolExecutor3 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程3"));
  private static ExecutorService threadPoolExecutor4 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程4"));
  private static ExecutorService threadPoolExecutor5 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程5"));
  private static ExecutorService threadPoolExecutor6 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程6"));
  private static ExecutorService threadPoolExecutor7 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程7"));
  private static ExecutorService threadPoolExecutor8 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程8"));
  private static ExecutorService threadPoolExecutor9 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程9"));
  private static ExecutorService threadPoolExecutor10 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程10"));
  private static ExecutorService threadPoolExecutor11 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程11"));
  private static ExecutorService threadPoolExecutor12 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程12"));
  private static ExecutorService threadPoolExecutor13 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程13"));
  private static ExecutorService threadPoolExecutor14 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程14"));
  private static ExecutorService threadPoolExecutor15 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程15"));
  private static ExecutorService threadPoolExecutor16 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程16"));
  private static ExecutorService threadPoolExecutor17 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程17"));
  private static ExecutorService threadPoolExecutor18 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程18"));
  private static ExecutorService threadPoolExecutor19 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程19"));
  private static ExecutorService threadPoolExecutor20 = Executors.newFixedThreadPool(20, new NamedThreadFactory("线程20"));


  private static int coreCount = Runtime.getRuntime().availableProcessors() * 2;
  private static ExecutorService myThreadPool =
    new ThreadPoolExecutor(coreCount, coreCount, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100), new NamedThreadFactory("测试线程"), new ThreadPoolExecutor.CallerRunsPolicy());

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println("开始时间：" + startTime + "," + coreCount+ "核");
    threadPoolGroup();
    //2020

//    for(int i=0; i< 20; i++){
//      try {
//        Thread.sleep(100L);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//      myThreadPool.submit(new MyTest());//2016
//    }
//    myThreadPool.shutdown();

    long endTime = System.currentTimeMillis();
    System.out.println("结束时间：" + endTime);
    System.out.println("花费时间：" + (endTime-startTime));
  }

  private static void threadPoolGroup() {
    threadPoolExecutor1.execute(new MyTest());
    testThreadPoll(threadPoolExecutor1);
    threadPoolExecutor2.execute(new MyTest());
    testThreadPoll(threadPoolExecutor2);
    threadPoolExecutor3.execute(new MyTest());
    testThreadPoll(threadPoolExecutor3);
    threadPoolExecutor4.execute(new MyTest());
    testThreadPoll(threadPoolExecutor4);
    threadPoolExecutor5.execute(new MyTest());
    testThreadPoll(threadPoolExecutor5);
    threadPoolExecutor6.execute(new MyTest());
    testThreadPoll(threadPoolExecutor6);
    threadPoolExecutor7.execute(new MyTest());
    testThreadPoll(threadPoolExecutor7);
    threadPoolExecutor8.execute(new MyTest());
    testThreadPoll(threadPoolExecutor8);
    threadPoolExecutor9.execute(new MyTest());
    testThreadPoll(threadPoolExecutor9);
    threadPoolExecutor10.execute(new MyTest());
    testThreadPoll(threadPoolExecutor10);
    threadPoolExecutor11.execute(new MyTest());
    testThreadPoll(threadPoolExecutor11);
    threadPoolExecutor12.execute(new MyTest());
    testThreadPoll(threadPoolExecutor12);
    threadPoolExecutor13.execute(new MyTest());
    testThreadPoll(threadPoolExecutor13);
    threadPoolExecutor14.execute(new MyTest());
    testThreadPoll(threadPoolExecutor14);
    threadPoolExecutor15.execute(new MyTest());
    testThreadPoll(threadPoolExecutor15);
    threadPoolExecutor16.execute(new MyTest());
    testThreadPoll(threadPoolExecutor16);
    threadPoolExecutor17.execute(new MyTest());
    testThreadPoll(threadPoolExecutor17);
    threadPoolExecutor18.execute(new MyTest());
    testThreadPoll(threadPoolExecutor18);
    threadPoolExecutor19.execute(new MyTest());
    testThreadPoll(threadPoolExecutor19);
    threadPoolExecutor20.execute(new MyTest());
    testThreadPoll(threadPoolExecutor20);

    threadPoolExecutor1.shutdown();
    threadPoolExecutor2.shutdown();
    threadPoolExecutor3.shutdown();
    threadPoolExecutor4.shutdown();
    threadPoolExecutor5.shutdown();
    threadPoolExecutor6.shutdown();
    threadPoolExecutor7.shutdown();
    threadPoolExecutor8.shutdown();
    threadPoolExecutor9.shutdown();
    threadPoolExecutor10.shutdown();
    threadPoolExecutor11.shutdown();
    threadPoolExecutor12.shutdown();
    threadPoolExecutor13.shutdown();
    threadPoolExecutor14.shutdown();
    threadPoolExecutor15.shutdown();
    threadPoolExecutor16.shutdown();
    threadPoolExecutor17.shutdown();
    threadPoolExecutor18.shutdown();
    threadPoolExecutor19.shutdown();
    threadPoolExecutor20.shutdown();
  }

  private static void testThreadPoll(ExecutorService threadPoolExecutor) {
    try {
      Thread.sleep(100L);
      threadPoolExecutor.execute(new MyTest());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      countThreadLocal.set(countThreadLocal.get()+1);
      if(countThreadLocal.get() % 10 == 1){
        System.out.println(Thread.currentThread().getName() + ",count=" + countThreadLocal.get());
      }

    }
  }

}
