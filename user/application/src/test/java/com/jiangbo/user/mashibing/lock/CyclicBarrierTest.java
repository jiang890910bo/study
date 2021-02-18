package com.jiangbo.user.mashibing.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏锁
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/14
 */
public class CyclicBarrierTest {

	public static void main(String[] args) throws Exception {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(20, new Runnable() {
			@Override
			public void run() {
				System.out.println("满人，发车。");
			}
		});
		for (int i = 0; i < 100; i++) {
			new Thread(()-> {
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
