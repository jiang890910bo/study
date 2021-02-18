package com.jiangbo.user.mashibing.lock.taobaoquestion.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 淘宝一个面试题：
 * 实现一个容器，提供俩个方法add、size, 写两个线程
 * 线程1，添加10个元素到容器中
 * 线程2，实时监控元素个数，当个数到5个时，线程2给出提示并结束。
 *
 * @author 使用LockSupport
 * @version 1.0.0
 * @date 2021/02/15
 */
public class TaobaoQuestionTest4 {

  static List<Integer> list = new ArrayList<>();

	static Thread thread0 = null;
	static Thread thread1 = null;

	public static void add(int value){
		list.add(value);
	}

	public static int size(){
		return list.size();
	}

	public static void main(String[] args) {


		thread0 = new Thread(()->{
			try {
				for (int i = 0; i < 10; i++) {
						System.out.println("add:" + i);
						add(i);
						if(size() == 5) {
							LockSupport.unpark(thread1);
							LockSupport.park();
						}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		thread1 = new Thread(()->{
				try {
					LockSupport.park();
					System.out.println("到第5个元素了，结束。");
					LockSupport.unpark(thread0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		});

		thread1.start();
		thread0.start();
	}
}
