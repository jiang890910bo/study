package com.jiangbo.user.mashibing.blocking;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * BlockingListTest1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/11
 */
public class BlockingListTest3 {

	static ArrayBlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<Integer>(10);
	static CountDownLatch productCondition = new CountDownLatch(10);
	static CountDownLatch consumerCondition = new CountDownLatch(0);

	public static void main(String[] args) {
		Thread productThread = new Thread("线程1") {
			@SneakyThrows
			@Override
			public void run() {
				int count = 0;
				while(true){
					if (productCondition.getCount() > 0) {
							System.out.println("塞入值：" + count);
							blockingDeque.add(count);
							count++;
							productCondition.countDown();
						if(blockingDeque.size() == 10){
							System.out.println("producer-1-已塞满，执行consumerCondition = new CountDownLatch(10)");
							consumerCondition = new CountDownLatch(10);
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
					while (consumerCondition.getCount() > 0) {
						System.out.println("拿出值：" + blockingDeque.poll());
						consumerCondition.countDown();
						if (blockingDeque.size() == 0) {
							System.out.println("consumer-1-已拿完，执行productCondition = new CountDownLatch(10)");
							productCondition = new CountDownLatch(10);
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
