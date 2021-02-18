package com.jiangbo.user.mashibing.lock.taobaoquestion.two;

import java.util.LinkedList;

/**
 * 写一个固定容量同步容器，拥有put和get方法，以及getCount方法，能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/15
 */
public class MultiThreadContainerTest {

	static LinkedList<String> linkedList= new LinkedList<>();
	static final int MAX_COUNT = 10;
	volatile int count = 0;

	public synchronized void put(String value) throws InterruptedException {
		if(getCount() < MAX_COUNT){//此处使用if有问题，因为count不是线程安全的
			linkedList.add(value);
			++count;
			notifyAll();//通知消费者消费
		}else if(getCount() == MAX_COUNT){
//			System.out.println(Thread.currentThread().getName() + "->put等待...");
			this.wait();
//			System.out.println(Thread.currentThread().getName() + "->put被唤醒...");
		}
	}

	public synchronized String get() throws Exception {
		if(getCount() > 0) {//此处使用if有问题，因为count不是线程安全的
			String value = linkedList.removeFirst();
			--count;
			notifyAll();//通知生产者放值
			return value;
		}else if(getCount() == 0){
			//System.out.println(Thread.currentThread().getName() + "->get等待...");
			this.wait();
//			System.out.println(Thread.currentThread().getName() + "->get被唤醒...");
			get();
		}

		return null;
	}

	public  Integer getCount(){
		System.out.println(Thread.currentThread().getName() + " count:"+ count);
		return count;
	}

	public static void main(String[] args) {
		MultiThreadContainerTest multiThreadContainerTest = new MultiThreadContainerTest();

		Thread[] productThreads = new Thread[2];
		for (int i = 0; i < productThreads.length; i++) {
			productThreads[i] = new Thread(()->{
				for (int j = 0; j < 25; j++) {
					try {
						multiThreadContainerTest.put(Thread.currentThread().getName() + "-" + j);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});

		}

		Thread[] consumerThreads = new Thread[10];
		for (int i = 0; i < consumerThreads.length; i++) {
			consumerThreads[i] = new Thread(()->{
				for (int j = 0; j < 5; j++) {
					try {
						System.out.println(multiThreadContainerTest.get());;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});


		}


		for (Thread t:productThreads) {
			t.start();
		}
		for (Thread t:consumerThreads) {
			t.start();
		}
	}

}
