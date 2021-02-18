package com.jiangbo.user;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * AreaCodeTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/11/01
 */
public class AreaCodeTest {
  public static void main(String[] args) {
//    String code = "0798";
//    int virtualCode = 10798;
//    System.out.println("0" + (virtualCode - 10000));
    LinkedBlockingQueue<String> listBlockQueue = new LinkedBlockingQueue(5);
    int i = 0;
    while(true){
      i++;
      listBlockQueue.add("" + i);
      System.out.println(listBlockQueue.size());
    }

  }
}
