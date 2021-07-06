package com.jiangbo.user.mashibing.zaobaozi;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 包子铺2个人造包子，3个消费者人吃包子；笼内有最多容纳5个包子；包子没有了需要造包子；笼内放满了包子，停止造包子；只要笼内有包子，消费者就可以吃包子。
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/06/22
 */
public class Zaobaozi {

	private int size = 5;
	private volatile LinkedList<String> zhenglong = new LinkedList<String>();


	private  int getSize(){
		return zhenglong.size();
	}

	@SneakyThrows
	private synchronized void put(String baozi) {
		while(getSize() == size) {
			System.out.println(Thread.currentThread().getName() + "蒸笼已满，停止放包子。");
			this.notifyAll();
			this.wait();
		}
		zhenglong.add(baozi);
		System.out.println(Thread.currentThread().getName() + "放入包子:" + baozi + ", 现有" + getSize() + "个包子。");
	}

	@SneakyThrows
	private synchronized void take() {
		while(getSize() == 0) {
			System.out.println(Thread.currentThread().getName() + "蒸笼没有包子了，请稍等。");
			this.notifyAll();
			this.wait();
		}
		String baozi = zhenglong.removeFirst();
		System.out.println(Thread.currentThread().getName() + "拿到包子：" + baozi + ", 还剩：" + getSize() + "个。");
	}

	public static void main(String[] args) {
		Zaobaozi zaobaozi = new Zaobaozi();
		for (int i = 0; i < 2; i++) {
			new Thread(()->{
				while(true){
					zaobaozi.put("包子");
					try {
						Thread.sleep(100L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}


		for (int i = 0; i < 3; i++) {
			new Thread(()->{
				while(true){
					zaobaozi.take();
					try {
						Thread.sleep(100L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}

	}
}
