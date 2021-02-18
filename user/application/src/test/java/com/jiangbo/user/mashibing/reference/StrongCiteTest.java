package com.jiangbo.user.mashibing.reference;

import java.io.IOException;

/**
 * 普通引用(强引用)：只要有一个应用指向这个对象，那么垃圾回收器一定不会回收它。
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/17
 */
public class StrongCiteTest {

	/**
	 * 垃圾回收的时候，它是会调用finalize这个方法。
	 * @throws Throwable
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}

	public static void main(String[] args) throws IOException {
		StrongCiteTest strongCiteTest = new StrongCiteTest();
		System.gc();//Disable Explicit GC
		System.in.read();//调用阻塞方法，不然main方法退出。
	}
}
