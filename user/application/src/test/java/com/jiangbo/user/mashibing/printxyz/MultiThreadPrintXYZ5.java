package com.jiangbo.user.mashibing.printxyz;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * MultiThreadPrintXYZ1
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/08
 */
public class MultiThreadPrintXYZ5 {
	static ReentrantLock lock = new ReentrantLock();
	static Condition countX = lock.newCondition();
	static Condition countY = lock.newCondition();
	static Condition countZ = lock.newCondition();
	static AtomicInteger count = new AtomicInteger(0);

	@SneakyThrows
	public static void main(String[] args) {
		Thread thread1 = new Thread() {
			@SneakyThrows
			@Override
			public void run() {
				while (count.get() < 10) {
					if (lock.tryLock()) {
						try {
							printX();
							System.out.println("X1——枷锁成功, 执行countY.signal()");
							countY.signal();
							System.out.println("X2——执行countY.signal() finish, 接着执行countX.await()");
							countX.await();
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							System.out.println("X3——接着执行lock.unlock()");
							lock.unlock();
						}
					}

				}
			}
		};

		Thread thread2 = new Thread() {
			@SneakyThrows
			@Override
			public void run() {
				while (count.get() < 10) {
					if (lock.tryLock()) {
						try {
							printY();
							System.out.println("Y1——枷锁成功, 执行countZ.signal()");
							countZ.signal();
							System.out.println("Y2——执行countZ.signal() finish, 接着执行countY.await()");
							countY.await();
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							System.out.println("Y3——接着执行lock.unlock()");
							lock.unlock();
						}
					}

				}
			}
		};

		Thread thread3 = new Thread() {
			@SneakyThrows
			@Override
			public void run() {
				while (count.get() < 10) {
					if (lock.tryLock()) {
						try {
							printZ();
							System.out.println("Z1——枷锁成功, 执行countX.signal()");
							count.set(count.incrementAndGet());
							countX.signal();
							System.out.println("Z2——执行countX.signal() finish, 接着执行countZ.await()");
							if (count.get() >= 10) {
								Thread.currentThread().interrupt();
							} else {
								countZ.await();
							}
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							System.out.println("Z3——接着执行lock.unlock()");
							lock.unlock();
						}
					}

				}
			}
		};

		thread1.start();
		Thread.sleep(100L);
		thread2.start();
		thread3.start();
	}


	public static void printX() {
		System.out.print("X");
	}

	public static void printY() {
		System.out.print("Y");
	}

	public static void printZ() {
		System.out.println("Z  ");
	}
}
