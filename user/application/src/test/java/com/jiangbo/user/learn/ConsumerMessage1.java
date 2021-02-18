package com.jiangbo.user.learn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * ConsumerMessage1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/13
 */
public class ConsumerMessage1 {

	static CountDownLatch count = new CountDownLatch(10);
	static BlockingQueue blockingQueue = new ArrayBlockingQueue<String>(10);

	public static void main(String[] args) {
		Thread producerThread = new Thread(){
			@Override
			public void run() {
				int num = 0;
				while(true){
					if(count.getCount() > 0){
						System.out.println("塞入值：" + num);
						blockingQueue.add(num);
						num ++;
						count.countDown();
						if(count.getCount() == 0){
							System.out.println("已塞满。");
						}
					}
				}
			}
		};

		Thread consumerThread = new Thread(){
			@Override
			public void run() {
				while(true){
					if(count.getCount() == 0){
						System.out.println("拿出值：" + blockingQueue.poll());
						if(blockingQueue.size() == 0){
							System.out.println("已拿完。");
							count = new CountDownLatch(10);
						}
					}
				}

			}
		};

		producerThread.start();
		consumerThread.start();
	}
}
