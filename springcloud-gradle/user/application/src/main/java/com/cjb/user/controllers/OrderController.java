package com.cjb.user.controllers;

import com.alibaba.fastjson.JSONObject;
import com.cjb.user.applications.UserService;
import com.cjb.user.domain.StudentService;
import com.cjb.user.domain.UserInterface;
import com.cjb.user.domain.entity.Student;
import com.cjb.user.domain.entity.Teacher;
import com.cjb.user.kafka.mq.KafkaProducer;
import com.cjb.user.message.OrderStatusMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * OrderController
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/13
 * @Version 1.0.0
 */
@Slf4j
@RestController(value = "/order")
public class OrderController implements Runnable{

  @Autowired
  private KafkaProducer kafkaProducer;
  @Autowired
  private UserService userService;

  private static int corePoolSize = Runtime.getRuntime().availableProcessors();

  private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, corePoolSize, 0L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));

  @GetMapping(value = "/studentSay")
  public String studentSay(){
    UserInterface userInterface = userService.getUserInterfaceMap().get(Student.class);
    return userInterface.say("hello");
  }

  @GetMapping(value = "/teacherSay")
  public String teacherSay(){
    UserInterface userInterface = userService.getUserInterfaceMap().get(Teacher.class);
    return userInterface.say("hello");
  }

  @PostMapping(value = "/send")
  public String send(){
    for (int i = 0; i < 50; i++) {
      threadPoolExecutor.execute(this::run);
    }
    return Strings.EMPTY;
  }



  private void sendTest(){
    OrderStatusMessage orderStatusMessage = new OrderStatusMessage();
    orderStatusMessage.setAppId("1007");
    for(int i = 0 ;i < 100; i++) {
      log.info("thread-name:{}", Thread.currentThread().getName());
      orderStatusMessage.setChangeTime(System.currentTimeMillis());
      orderStatusMessage.setOrderNo(UUID.randomUUID().toString());
      orderStatusMessage.setProvider("12.39999961853027");
      kafkaProducer.sendMq(orderStatusMessage);
    }
  }

  @Override
  public void run() {
    sendTest();
  }
}
