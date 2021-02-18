package com.jiangbo.user.learn;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ConsumerMessage1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/13
 */
public class ConsumerMessage3 {

	static BlockingQueue blockingQueue = new ArrayBlockingQueue<String>(10);
	static ReentrantLock lock = new ReentrantLock();
	static Condition producerCondition = lock.newCondition();
	static Condition consumerCondition = lock.newCondition();

	public static void main(String[] args) {
		Thread producerThread = new Thread(){
			@SneakyThrows
			@Override
			public void run() {
				int num = 0;
				while(true){
					if(lock.tryLock()){
						System.out.println("塞入值：" + num);
						blockingQueue.add(num);
						num ++;
						if(blockingQueue.size() == 10){
							System.out.println("已塞满。");
							consumerCondition.signal();
							producerCondition.await();
							lock.unlock();
						}
					}
				}
			}
		};

		Thread consumerThread = new Thread(){
			@SneakyThrows
			@Override
			public void run() {
				while(true){
					if(lock.tryLock()){
						System.out.println("拿出值：" + blockingQueue.poll());
						if(blockingQueue.size() == 0){
							System.out.println("已拿完。");
							producerCondition.signal();
							consumerCondition.await();
							lock.unlock();
						}
					}
				}

			}
		};

		producerThread.start();
		consumerThread.start();
	}
}
