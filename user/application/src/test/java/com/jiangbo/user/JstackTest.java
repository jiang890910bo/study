package com.jiangbo.user;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JstackTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/23
 */

public class JstackTest {


  public static void main(String[] args) {
	  System.out.println("start...");
		testWileTrue();
		//testReadIn();
		//testDeadLock();
	  System.out.println("End...");
  }

	/**
	 * 测试死循环
	 */
	private static void testDeadLock() {
		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();

		new Thread(()->{
			try {
				lock1.lock();
				Thread.sleep(1000L);
				lock2.lock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}


	/**
	 * 测试等待响应
	 */
	private static void testReadIn() {
		try {
			System.out.println("等待响应");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试死循环
	 */
	private static void testWileTrue() {
  	while(true){
		  System.out.println("死循环");
	  }
	}




}
