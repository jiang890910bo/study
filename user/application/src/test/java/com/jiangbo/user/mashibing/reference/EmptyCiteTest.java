package com.jiangbo.user.mashibing.reference;

import java.lang.ref.WeakReference;

/**
 * EmptyCiteTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/17
 */
public class EmptyCiteTest {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}

	public static void main(String[] args) {
		WeakReference<EmptyCiteTest> m = new WeakReference<>(new EmptyCiteTest());
		System.out.println(m.get());
		System.gc();
		System.out.println(m.get());
		ThreadLocal<EmptyCiteTest> tl = new ThreadLocal<>();
		tl.set(new EmptyCiteTest());
		tl.remove();
	}
}
