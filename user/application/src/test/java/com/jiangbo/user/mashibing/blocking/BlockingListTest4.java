package com.jiangbo.user.mashibing.blocking;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * BlockingListTest1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/11
 */
public class BlockingListTest4 {

	static ArrayBlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<Integer>(10);
	static AtomicBoolean sign = new AtomicBoolean(Boolean.TRUE);

	public static void main(String[] args) {
		Thread productThread = new Thread("线程1") {
			@SneakyThrows
			@Override
			public void run() {
				int count = 0;
				while(true){
					if (sign.get()) {
							System.out.println("塞入值：" + count);
							blockingDeque.add(count);
							count++;
						if(blockingDeque.size() == 10){
							System.out.println("producer-1-已塞满，执行sign = 10");
							sign.set(Boolean.FALSE);
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
					while (! sign.get()) {
						System.out.println("拿出值：" + blockingDeque.poll());
						if (blockingDeque.size() == 0) {
							System.out.println("consumer-1-已拿完，执行sign = 0");
							sign.set(Boolean.TRUE);
						}

					}
				}
			}
		};


		productThread.start();
		consumerThread.start();
	}
}
