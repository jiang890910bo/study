package com.jiangbo.user.mashibing.printxyz;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ABC_Condition
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/09
 */
public class ABC_Condition {
	private static Lock lock = new ReentrantLock();
	private static Condition A = lock.newCondition();
	private static Condition B = lock.newCondition();
	private static Condition C = lock.newCondition();

	private static int count = 0;

	static class ThreadA extends Thread {
		@Override
		public void run() {
			try {
				lock.lock();
				System.out.println("ThreadA-2-执行lock.lock() finish,开始for循环");
				for (int i = 0; i < 10; i++) {
					while (count % 3 != 0) {//注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
						System.out.println("ThreadA-2.1-执行for循环时，碰到（count % 3 != 0），执行A.await()");
						A.await(); // A释放lock锁
					}
					System.out.println("ThreadA-2.2执行for循环时，打印字母A");
					System.out.print("A");
					count++;
					System.out.println("ThreadA-2.3-执行打印字母A finish, 执行B.signal()");
					B.signal(); // A执行完唤醒B线程
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("ThreadA-3-使释放锁");
				lock.unlock();
			}
		}
	}

	static class ThreadB extends Thread {
		@Override
		public void run() {
			try {
				lock.lock();
				System.out.println("ThreadB-2-执行lock.lock() finish,开始for循环");
				for (int i = 0; i < 10; i++) {
					while (count % 3 != 1) {
						System.out.println("ThreadB-2.1-执行for循环时，碰到（count % 3 != 0），执行B.await()");
						B.await();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程
					}
					System.out.println("ThreadB-2.2执行for循环时，打印字母B");
					System.out.print("B");
					count++;
					System.out.println("ThreadB-2.3-执行打印字母B finish, 执行B.signal()");
					C.signal();// B执行完唤醒C线程
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("ThreadB-3-使释放锁");
				lock.unlock();
			}
		}
	}

	static class ThreadC extends Thread {
		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					while (count % 3 != 2)
						C.await();// C释放lock锁
					System.out.print("C");
					count++;
					A.signal();// C执行完唤醒A线程
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();
	}
}
