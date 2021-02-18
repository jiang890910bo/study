package com.jiangbo.user;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

/**
 * ListStreamForeachTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/11/18
 */
public class ListStreamForeachTest {
  public static void main(String[] args) {

    long start = System.currentTimeMillis();
    for(int i = 0;i <10000; i++) {
      new Thread("thread" + i) {
        @Override
        public void run() {
          loop();
        }
      }.start();
    }

    System.out.println("耗时：" +  (System.currentTimeMillis() - start));
  }


  public static void  loop(){
    long start = System.currentTimeMillis();

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 300; i++) {
      list.add(i);
    }

    list.stream().forEach(var ->{
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    System.out.println("单个循环耗时：" +  (System.currentTimeMillis() - start));
  }

}
