package com.jiangbo.user.mashibing.lock.taobaoquestion.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 淘宝一个面试题：
 * 实现一个容器，提供俩个方法add、size, 写两个线程
 * 线程1，添加10个元素到容器中
 * 线程2，实时监控元素个数，当个数到5个时，线程2给出提示并结束。
 *
 * @author 使用volatitle
 * @version 1.0.0
 * @date 2021/02/15
 */
public class TaobaoQuestionTest {

	//static List<Integer> list = new ArrayList<>();//有问题
	volatile static List<Integer> list = new ArrayList<>();//仍然有问题

	public static void add(int value){
		list.add(value);
	}

	public static int size(){
		return list.size();
	}

	public static void main(String[] args) {
		Thread thread0 = new Thread(()->{
			for (int i = 0; i < 10; i++) {
					System.out.println("add:" + i);
					add(i);
			}
		});

		Thread thread1 = new Thread(()->{
			while(true){
				if(size() == 5){
					System.out.println("到第5个元素了，终止添加。");
				}
			}
		});

		thread0.start();
		thread1.start();
	}
}
