package com.jiangbo.user.mashibing.printxyz;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MultiThreadPrintXYZ1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/08
 */
public class MultiThreadPrintXYZ4 {

	static Semaphore countX = new Semaphore(1);
	static Semaphore countY = new Semaphore(0);
	static Semaphore countZ = new Semaphore(0);

	static AtomicInteger count = new AtomicInteger(0);

	@SneakyThrows
	public static void main(String[] args) {
		Thread threadX = new Thread(() -> {
			while(count.get() < 10) {
				if(countX.tryAcquire()) {
					try {
						System.out.print("X");
						countY.release();
					}catch (Exception e){
						e.printStackTrace();
					}
				}

			}
		});

		Thread threadY = new Thread(() -> {
			while(count.get() < 10) {
				if(countY.tryAcquire()) {
					try {
						System.out.print("Y");
						countZ.release();
					}catch (Exception e){
						e.printStackTrace();
					}
				}

			}
		});

		Thread threadZ = new Thread(() -> {
			while(count.get() < 10) {
				if(countZ.tryAcquire()) {
					try {
						System.out.print("Z  ");
						count.set(count.incrementAndGet());
						countX.release();
					}catch (Exception e){
						e.printStackTrace();
					}
				}

			}

		});

		threadX.start();
		threadY.start();
		threadZ.start();
	}

	public static void printX(){
		System.out.print("X");
	}

	public static void printY(){
		System.out.print("Y");
	}

	public static void printZ(){
		System.out.println("Z  ");
	}
}
