package com.jiangbo.user.mashibing.synchronize;

/**
 * SynchronizedTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/16
 */
public class SynchronizedTest {
	//int count = 20;
	static int count = 5;//count是线程不安全的

	public synchronized void sell1(){
		if(count > 0) {
			--count;
			System.out.println(Thread.currentThread().getName() + ",卖出一张. 还剩" + count + "张。");
		}else{
			System.out.println(Thread.currentThread().getName() + ",票已卖完");
		}
	}

	public static synchronized void sell2(){
		if(count > 0) {
			--count;
			System.out.println(Thread.currentThread().getName() + ",卖出一张. 还剩" + count + "张。");
		}else{
			System.out.println(Thread.currentThread().getName() + ",票已卖完");
		}
	}

	public static void main(String[] args) {
		SynchronizedTest test = new SynchronizedTest();
		Thread thread0 = new Thread(()->{
			for (int i = 0; i < 5; i++) {
				test.sell1();
//				SynchronizedTest.sell2();
			}
		});

		Thread thread1 = new Thread(()->{
			for (int i = 0; i < 5; i++) {
//				test.sell1();
				SynchronizedTest.sell2();
			}
		});

		thread0.start();
		thread1.start();
	}
}
