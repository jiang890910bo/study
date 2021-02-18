package com.jiangbo.user.mashibing.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试：
 * 1、读读不排斥
 * 2、读写排斥
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/14
 */
public class ReentrantWriteLockTest {
	static Lock lock = new ReentrantLock();
	static int value;

	static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	static Lock readLock = readWriteLock.readLock();
	static Lock writeLock = readWriteLock.writeLock();

	public static void read(Lock lock){
		try {
			lock.lock();
			Thread.sleep(1000);
			System.out.println("read over!");
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public static void write(Lock lock, int v){
		try {
			lock.lock();
			Thread.sleep(1000);
			value = v;
			System.out.println("write over!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
//		Runnable readR = ()->read(lock);
//		Runnable writeR = ()->write(lock, new Random().nextInt());

		Runnable readR = ()->read(readLock);
		Runnable writeR = ()->write(writeLock, new Random().nextInt());

		for (int i = 0; i < 18; i++) {
			new Thread(readR).start();
		}
		for (int i = 0; i < 2; i++) {
			new Thread(writeR).start();
		}
	}
}
