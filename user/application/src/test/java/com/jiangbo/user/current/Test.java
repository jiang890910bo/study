package com.jiangbo.user.current;

/**
 * Test
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/03/17
 */
public class Test {

	public static void main(String[] args) {
		Thread thread1 = new Thread(()->{
			TaskA taskA = new TaskA();
			taskA.init();
		});

		Thread thread2 = new Thread(()->{
			TaskB taskB = new TaskB();
			taskB.init();
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
