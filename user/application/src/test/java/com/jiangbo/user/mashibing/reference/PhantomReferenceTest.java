package com.jiangbo.user.mashibing.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * 虚引用：管理推外内存，给写JVM虚拟机的人用的。
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/17
 */
public class PhantomReferenceTest {
	static final List<Object> LIST = new LinkedList<>();
	static final ReferenceQueue<PhantomReferenceTest> QUEUE = new ReferenceQueue<>();

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize");
	}

	public static void main(String[] args) {
		PhantomReference<PhantomReferenceTest> phantomReference = new PhantomReference<>(new PhantomReferenceTest(), QUEUE);
		new Thread(()->{
			while (true){
				LIST.add(new byte[1024 *1024]);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(phantomReference.get());
			}
		}).start();

		new Thread(()->{
			while (true){
				Reference<? extends  PhantomReferenceTest> poll = QUEUE.poll();
				if(poll != null){
					System.out.println("---- 虚引用对象被jvm回收了 ----");
				}

			}
		}).start();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
