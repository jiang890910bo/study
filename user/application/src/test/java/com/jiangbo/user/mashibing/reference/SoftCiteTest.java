package com.jiangbo.user.mashibing.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用：当有一个对象被一个软引用所指向的时候，只有系统内存不够用的时候，才会回收它.
 * 注意：启动时，设置jvm启动参数值： -Xmx20M -Xmx20M
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/17
 */
public class SoftCiteTest {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}

	public static void main(String[] args) {
		SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
		System.out.println(m.get());
		System.gc();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(m.get());
		//再分配一下数组，heap将装不下，这时候会垃圾回收，先回收一次，如果不够，会把软引用干掉。
		byte[] b = new byte[1024 * 1024 *11];
		System.out.println(m.get());
	}
}
