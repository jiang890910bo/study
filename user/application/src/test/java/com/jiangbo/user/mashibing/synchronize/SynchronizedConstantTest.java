package com.jiangbo.user.mashibing.synchronize;

import java.util.concurrent.CountDownLatch;

/**
 * SynchronizedConstantTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/14
 */
public class SynchronizedConstantTest {
//	static  String lock = "lock"; 不建议使用基本类型作为锁，因为很有可能基本类型声明在类的外面，被公用。被公用时，其他使用它也作为锁时，则可能被锁的时同一个对象。
	static Object lock = new Object();
	static final CountDownLatch countDownLatch = new CountDownLatch(2);
	static int num = 0;

	public  static void count(){
		synchronized(lock) {
			num++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(num);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread0 = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					count();
				}
				countDownLatch.countDown();
			}
		};

		Thread thread1 = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					count();
				}
				countDownLatch.countDown();
			}
		};

		thread0.start();
		thread1.start();

		countDownLatch.await();
		System.out.println("num=" + num);
	}
}
