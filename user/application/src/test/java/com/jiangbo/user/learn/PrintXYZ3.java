package com.jiangbo.user.learn;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * PrintXYZ1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/13
 */
public class PrintXYZ3 {

	static CountDownLatch count = new CountDownLatch(10);
	static ReentrantLock lock = new ReentrantLock();
	static Condition sign0 = lock.newCondition();
	static Condition sign1 = lock.newCondition();
	static Condition sign2 = lock.newCondition();


	public static void main(String[] args) {
		Thread thread0 = new Thread("thread0"){
			@SneakyThrows
			@Override
			public void run() {
				while (true){
					if(lock.tryLock()){
						System.out.print("X");
						sign1.signal();
						sign0.await();
						lock.unlock();
					}
				}
			}
		};

		Thread thread1 = new Thread("thread1"){
			@SneakyThrows
			@Override
			public void run() {
				while (true){
					if(lock.tryLock()){
						System.out.print("Y");
						sign2.signal();
						sign1.await();
						lock.unlock();
					}
				}
			}
		};

		Thread thread2 = new Thread("thread2"){
			@SneakyThrows
			@Override
			public void run() {
				while (true){
					if(lock.tryLock()){
						System.out.println("Z");
						count.countDown();
						if(count.getCount() > 0) {
							sign0.signal();
						}
						sign2.await();
						lock.unlock();
					}
				}
			}
		};

		thread0.start();
		thread1.start();
		thread2.start();
	}
}
