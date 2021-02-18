package com.jiangbo.user;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TwoThreadTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/09/27
 */
public class TwoThreadTest {
  private static ReentrantLock reentrantLock = new ReentrantLock();

  private static Condition condition1 = reentrantLock.newCondition();
  private static Condition condition2 = reentrantLock.newCondition();

  private static String words[]={"A", "B", "C", "D", "E"};
  private static Integer numbers[]={1, 2, 3, 4, 5};

  private static Thread threadWord;
  private static Thread threadNumber;

  public static void main(String[] args) {
    threadWord = new Thread(){
        @Override
        public void run() {
          TwoThreadTest.printWord();
        }
      };

    threadNumber = new Thread(){
      @Override
      public void run() {
        TwoThreadTest.printNUmber();
      }
    };

    threadWord.start();
    threadNumber.start();
  }

  @SneakyThrows
  public static void printWord() {

    reentrantLock.lock();
    try {
      for (int i = 0; i  < words.length; i ++) {
        System.out.println("===字母==" + words[i]);
        condition1.signal();
        condition2.await();
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    }  finally {
      reentrantLock.unlock();
    }

  }

  @SneakyThrows
  public static void printNUmber(){
    reentrantLock.lock();

    try {
      for (int i = 0; i  < numbers.length; i ++) {
        System.out.println("===数字==" + numbers[i]);
        condition2.signal();
        condition1.await();
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      reentrantLock.unlock();
    }

  }
}
