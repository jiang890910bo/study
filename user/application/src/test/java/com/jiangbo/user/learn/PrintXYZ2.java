package com.jiangbo.user.learn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * PrintXYZ1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/13
 */
public class PrintXYZ2 {

	static CountDownLatch count = new CountDownLatch(10);
	static Semaphore sign0 = new Semaphore(1);
	static Semaphore sign1 = new Semaphore(0);
	static Semaphore sign2 = new Semaphore(0);


	public static void main(String[] args) {
		Thread thread0 = new Thread("thread0"){
			@Override
			public void run() {
				while (true){
					if(sign0.tryAcquire()){
						System.out.print("X");

						if(sign0.availablePermits() == 0){
							sign1.release(1);
						}
					}
				}
			}
		};

		Thread thread1 = new Thread("thread1"){
			@Override
			public void run() {
				while (true){
					if(sign1.tryAcquire()){
						System.out.print("Y");

						if(sign1.availablePermits() == 0){
							sign2.release(1);
						}
					}
				}
			}
		};

		Thread thread2 = new Thread("thread2"){
			@Override
			public void run() {
				while (true){
					if(sign2.tryAcquire()){
						System.out.println("Z");
						count.countDown();
						if(sign2.availablePermits() == 0){
							if(count.getCount() > 0) {
								sign0.release(1);
							}
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
