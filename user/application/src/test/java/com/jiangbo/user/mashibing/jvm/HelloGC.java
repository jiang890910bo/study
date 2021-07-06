package com.jiangbo.user.mashibing.jvm;

import org.apache.lucene.util.RamUsageEstimator;

import java.util.LinkedList;
import java.util.List;

/**
 * HelloGC
 *
 * 堆溢出：
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at com.jiangbo.user.mashibing.jvm.HelloGC.main(HelloGC.java:18)
 */
public class HelloGC {
	public static void main(String[] args) {
		System.out.println("Hello GC!");
		List list = new LinkedList();
		for (int i = 0;;i++){
			System.out.println("...i=" + i);
			byte[] bytes = new byte[1024 * 1024];//1M
			//单位byte（最小字节单位）
			System.out.println(RamUsageEstimator.sizeOf(bytes));
			list.add(bytes);
			System.out.println(RamUsageEstimator.sizeOf(list.toString().getBytes()));

		}
	}
}
