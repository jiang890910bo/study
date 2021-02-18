package com.jiangbo.user.mashibing.lock.taobaoquestion.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * 淘宝一个面试题：
 * 实现一个容器，提供俩个方法add、size, 写两个线程
 * 线程1，添加10个元素到容器中
 * 线程2，实时监控元素个数，当个数到5个时，线程2给出提示并结束。
 *
 * @author 使用semphore，结合线程join方法
 * @version 1.0.0
 * @date 2021/02/15
 */
public class TaobaoQuestionTest5 {

  static List<Integer> list = new ArrayList<>();

	static Semaphore semaphore0 = new Semaphore(1);
	static Semaphore semaphore1 = new Semaphore(0);


	public static void add(int value){
		list.add(value);
	}

	public static int size(){
		return list.size();
	}

	public static void main(String[] args) {

		Thread thread1 = new Thread(()->{
			try {
				semaphore1.acquire();
				System.out.println("到第5个元素了，结束。");
				semaphore1.release();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Thread thread0 = new Thread(()->{
			try {
				for (int i = 0; i < 10; i++) {
						System.out.println("add:" + i);
						add(i);
						if(size() == 5) {
							semaphore0.acquire();
							System.out.println("已通知t1");
							semaphore1.release(1);
							thread1.join();
							semaphore0.release();
						}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		thread1.start();
		thread0.start();
	}
}
