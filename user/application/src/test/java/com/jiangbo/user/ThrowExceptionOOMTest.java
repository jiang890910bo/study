package com.jiangbo.user;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThrowExceptionOOMTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/12/27
 */
@Slf4j
public class ThrowExceptionOOMTest {

	private static AtomicInteger count =  new AtomicInteger(0);

	public static void main(String[] args) {
		while(true) {
			try {
				Thread thread1 = new Thread(() -> {
					new ThrowExceptionOOMTest().testOOM();
				});
				Thread thread2 = new Thread(() -> {
					new ThrowExceptionOOMTest().testOOM();
				});
				thread1.start();
				thread2.start();
			} catch (Exception e) {
				log.error("exception:", e);
			}
		}
	}

	public void testOOM(){
			try {
				System.out.println("第" + count.incrementAndGet() + "次调用。");
				int i = 1/0;
				Thread.sleep(30000L);
			} catch (InterruptedException e) {
				log.error("exception:", e);
			}

	}
}
