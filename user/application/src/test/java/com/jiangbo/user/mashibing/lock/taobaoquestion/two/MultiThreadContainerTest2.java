package com.jiangbo.user.mashibing.lock.taobaoquestion.two;

import java.util.LinkedList;

/**
 * 写一个固定容量同步容器，拥有put和get方法，以及getCount方法，能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/15
 */
public class MultiThreadContainerTest2 {

	static LinkedList<String> linkedList= new LinkedList<>();
	static final int MAX_COUNT = 10;
	int count = 0;

	public synchronized void put(String value) throws InterruptedException {
		while(getCount() == MAX_COUNT){//想想为什么使用while,而不用if?
			//System.out.println(Thread.currentThread().getName() + "->put等待...");
			this.wait();
			//System.out.println(Thread.currentThread().getName() + "->put被唤醒...");
		}
		linkedList.add(value);
		++count;
		this.notifyAll();
	}

	public synchronized String get() throws Exception {
		while(getCount() == 0){//想想为什么使用while,而不用if?
			//System.out.println(Thread.currentThread().getName() + "->get等待...");
			this.wait();
			//System.out.println(Thread.currentThread().getName() + "->get被唤醒...");
		}
		String value = linkedList.removeFirst();
		--count;
		this.notifyAll();
		return value;
	}

	public   Integer getCount(){
		System.out.println(Thread.currentThread().getName() + " count:"+ count);
		return count;
	}

	public static void main(String[] args) {
		MultiThreadContainerTest2 multiThreadContainerTest = new MultiThreadContainerTest2();

		Thread[] productThreads = new Thread[2];
		for (int i = 0; i < productThreads.length; i++) {
			productThreads[i] = new Thread(()->{
				for (int j = 0; j < 25; j++) {
					try {
						multiThreadContainerTest.put(Thread.currentThread().getName() + "-" + j);
//						Thread.sleep(200);
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
