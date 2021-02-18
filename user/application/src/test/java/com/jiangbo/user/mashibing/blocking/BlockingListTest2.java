package com.jiangbo.user.mashibing.blocking;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * BlockingListTest1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/11
 */
public class BlockingListTest2 {

	static ArrayBlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<Integer>(10);
	static Semaphore productCondition = new Semaphore(10);
	static Semaphore consumerCondition = new Semaphore(0);

	public static void main(String[] args) {
		Thread productThread = new Thread("线程1") {
			@SneakyThrows
			@Override
			public void run() {
				int count = 0;
				while(true){
					if (productCondition.tryAcquire()) {
							System.out.println("塞入值：" + count);
							blockingDeque.add(count);
							count++;
						if(blockingDeque.size() == 10){
							System.out.println("producer-1-已塞满，执行consumerCondition.release(10)");
							consumerCondition.release(10);
						}

					}
				}
			}
		};

		Thread consumerThread = new Thread("线程2") {
			@SneakyThrows
			@Override
			public void run() {
				while (true){
					while (consumerCondition.tryAcquire()) {
						System.out.println("拿出值：" + blockingDeque.poll());
						if (blockingDeque.size() == 0) {
							System.out.println("consumer-1-已拿完，执行productCondition.release()");
							productCondition.release(10);
						}

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
