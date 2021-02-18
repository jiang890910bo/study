package com.jiangbo.user.mashibing.printxyz;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MultiThreadPrintXYZ1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/08
 */
public class MultiThreadPrintXYZ1 {
	static CountDownLatch countX = new CountDownLatch(1);
	static CountDownLatch countY = new CountDownLatch(0);
	static CountDownLatch countZ = new CountDownLatch(0);

	static AtomicInteger count = new AtomicInteger(0);

	@SneakyThrows
	public static void main(String[] args) {

		Thread threadX = new Thread() {
			@SneakyThrows
			@Override
			public void run() {
				while (count.get() < 10) {
					if (countX.getCount() > 0) {
						System.out.print("X");
						countX.countDown();
						countY = new CountDownLatch(1);
					}
				}
			}
		};

		Thread threadY = new Thread() {
			@SneakyThrows
			@Override
			public void run() {
				while (count.get() < 10) {
					if (countY.getCount() > 0) {
						System.out.print("Y");
						countY.countDown();
						countZ = new CountDownLatch(1);
					}
				}
			}
		};

		Thread threadZ = new Thread() {
			@SneakyThrows
			@Override
			public void run() {
				while (count.get() < 10) {
					if (countZ.getCount() > 0) {
						System.out.print("Z  ");
						count.set(count.incrementAndGet());
						countZ.countDown();
						countX = new CountDownLatch(1);
					}
				}
			}
		};

		threadX.start();
		threadY.start();
		threadZ.start();
	}

}
