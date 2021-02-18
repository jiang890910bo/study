package com.jiangbo.user.learn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * PrintXYZ1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/13
 */
public class PrintXYZ1 {

	static CountDownLatch count = new CountDownLatch(10);
	static AtomicInteger sign = new AtomicInteger(0);

	public static void main(String[] args) {
		Thread thread0 = new Thread("thread0"){
			@Override
			public void run() {
				while (true){
					if(sign.get() == 0){
						System.out.print("X");
						sign.set(1);
					}
				}
			}
		};

		Thread thread1 = new Thread("thread1"){
			@Override
			public void run() {
				while (true){
					if(sign.get() == 1){
						System.out.print("Y");
						sign.set(2);
					}
				}
			}
		};

		Thread thread2 = new Thread("thread2"){
			@Override
			public void run() {
				while (true){
					if(sign.get() == 2 && count.getCount() > 0){
						System.out.println("Z ");
						count.countDown();
						if(count.getCount() > 0){
							sign.set(0);
						}
					}
				}
			}
		};

		thread0.start();
		thread1.start();
		thread2.start();
	}
}
