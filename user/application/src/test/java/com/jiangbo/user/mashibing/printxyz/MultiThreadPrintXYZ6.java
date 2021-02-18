package com.jiangbo.user.mashibing.printxyz;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 耗CPU
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/08
 */
public class MultiThreadPrintXYZ6 {

	static volatile int sign = 1;
	static AtomicInteger count1 = new AtomicInteger(0);
	static LongAdder longAdder = new LongAdder();

	@SneakyThrows
	public static void main(String[] args) {
		Thread thread1 = new Thread(){
			@SneakyThrows
			@Override
			public void run() {
				while(count1.get() < 10) {
					if (sign == 1) {
							printX();
							sign = 2;
						}
					}
				}
		};

		Thread thread2 = new Thread(){
			@SneakyThrows
			@Override
			public void run() {
				while(count1.get() < 10) {
					if (sign == 2) {
						printY();
						sign = 3;
					}
				}
			}
		};

		Thread thread3 = new Thread(){
			@SneakyThrows
			@Override
			public void run() {
				while(count1.get() < 10) {
					if (sign == 3) {
						printZ();
						count1.incrementAndGet();
						sign = 1;
					}
				}
			}
		};

		thread1.start();
		thread2.start();
		thread3.start();
	}

	public static void printX(){
		System.out.print("X");
	}

	public static void printY(){
		System.out.print("Y");
	}

	public static void printZ(){
		System.out.println("Z");
	}

}
