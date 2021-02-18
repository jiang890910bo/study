package com.jiangbo.user.mashibing.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupportTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/14
 */
public class LockSupportTest {
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				if(i == 5){
					LockSupport.park();
				}
				System.out.println("i=" + i);
			}
		});

		thread.start();
		LockSupport.unpark(thread);//unpark方法可以先于park方法执行。

//		try {
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		LockSupport.unpark(thread);
	}
}
