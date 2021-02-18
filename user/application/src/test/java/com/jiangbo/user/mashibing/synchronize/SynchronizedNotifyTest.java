package com.jiangbo.user.mashibing.synchronize;

import java.io.IOException;

/**
 * SynchronizedNotifyTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/17
 */
public class SynchronizedNotifyTest {
	static Object obj = new Object();
	static char[] charABC = "ABCDEFGHIJ".toCharArray();
	static char[] charNum = "0123456789".toCharArray();

	public static void main(String[] args) throws IOException {
		Thread thread0 = new Thread(()->{
			synchronized (obj) {
				System.out.println("字母线程获得锁。");
				for (int i = 0; i < charABC.length; i++) {
					try {
						obj.notify();//唤醒争抢obj等待锁。
						System.out.println("字母线程唤醒数字线程。");
						obj.wait();//让出锁。
						System.out.print(charABC[i] + " ");

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				obj.notify();//防止最后的wait的线程没有执行完。
			}
		});
		thread0.start();


		Thread thread1 = new Thread(()->{
			synchronized (obj) {
				System.out.println("数字线程获得锁。");
				for (int i = 0; i < charNum.length; i++) {
					System.out.print(charNum[i] + " ");
					try {
						obj.notify();//唤醒争抢obj等待锁。
						System.out.println("数字线程唤醒字母线程。");
						obj.wait();//让出锁。
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				obj.notify();//防止最后的wait的线程没有执行完。
			}
		});
		thread1.start();

	}
}
