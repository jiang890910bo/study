package com.jiangbo.user.mashibing;

/**
 * 模拟线程乱序场景
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/10/31
 */
public class DisOrder {

  private static int x, y = 0;
  private static int a,b = 0;

  public static void main(String[] args) {
    for(int i = 0;; i++){
      x=0; y = 0;
      a=0; b = 0;

      Thread thread1 = new Thread(){
        @Override
        public void run() {
          a=1;
          x=b;
        }
      };

      Thread thread2 = new Thread(){
        @Override
        public void run() {
          b = 1;
          y = a;
        }
      };

      thread1.start();
      thread2.start();

      try {
        thread1.join();
        thread2.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      if(x == 0 && y == 0){
        System.out.println("循环"+ i +"次，出现乱序了");
        break;
      }
      //循环808051次，出现乱序了
      //循环1963919次，出现乱序了
    }
  }
}
