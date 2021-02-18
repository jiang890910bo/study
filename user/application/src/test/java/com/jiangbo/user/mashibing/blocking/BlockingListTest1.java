package com.jiangbo.user.mashibing.blocking;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * BlockingListTest1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/11
 */
public class BlockingListTest1 {

	static ArrayBlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<Integer>(10);
	static ReentrantLock lock = new ReentrantLock();
	static Condition productCondition = lock.newCondition();
	static Condition consumerCondition = lock.newCondition();

	public static void main(String[] args) {
		Thread productThread = new Thread("线程1"){
			@SneakyThrows
			@Override
			public void run() {
				int count = 0;
				while(lock.tryLock()) {
					if (blockingDeque.size() < 10) {
						System.out.println("塞入值：" + count);
						blockingDeque.add(count);
						count++;
					}else{
						System.out.println("producer-1-执行consumerCondition.signal()");
						consumerCondition.signal();
						System.out.println("producer-2-执行lock.unlock()");
						lock.unlock();
						System.out.println("producer-3-执行productCondition.await()");
						productCondition.await();
					}
				}
			}
		};

		Thread consumerThread = new Thread("线程2"){
			@SneakyThrows
			@Override
			public void run() {
				while (lock.tryLock()) {
					if (blockingDeque.size() > 0) {
						System.out.println("拿出值：" + blockingDeque.poll());
					} else {
						System.out.println("consumer-1-执行productCondition.signal()");
						productCondition.signal();
						consumerCondition.await();
						System.out.println("consumer-2-执行lock.unlock()");
						lock.unlock();
						System.out.println("consumer-3-执行consumerCondition.await()");

					}
				}
			}
		};


		productThread.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		consumerThread.start();
	}
}
