package com.jiangbo.user;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TwoThreadTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/09/27
 */
public class TwoThreadTest2 {

  public static void main(String[] args) {

    MyObject myObject = new MyObject();
    myObject.setName("测试1");
    MyObject finalMyObject1 = myObject;
    Thread thread1 = new Thread("测试1"){
        @Override
        public void run() {
          TwoThreadTest2.printWord(finalMyObject1);
        }
      };

    myObject = new MyObject();
    myObject.setName("测试2");
    MyObject finalMyObject2 = myObject;
    Thread thread2 = new Thread("测试2"){
      @Override
      public void run() {
        TwoThreadTest2.printWord(finalMyObject2);
      }
    };

    myObject = new MyObject();
    myObject.setName("测试3");
    MyObject finalMyObject3 = myObject;
    Thread thread3 = new Thread("测试3"){
      @Override
      public void run() {
        TwoThreadTest2.printWord(finalMyObject3);
      }
    };

    thread1.start();
    thread2.start();
    thread3.start();
  }

  //private static AtomicInteger num = new AtomicInteger(0);
  private static int num = 0;

  @SneakyThrows
  public static void printWord(MyObject myObject1) {
    num +=1;

    MyObject myObject = myObject1;
    if(! Thread.currentThread().getName().equals(myObject.getName())) {
      System.out.println("error:" + Thread.currentThread().getName() + ":" + myObject.getName());
    }else{
      System.out.println(Thread.currentThread().getName() + ":" + myObject.getName());
    }
    System.out.println(Thread.currentThread().getName() + ":num=" + num);
  }

  @Getter
  @Setter
  public static class MyObject{
    private String name;
  }
}
