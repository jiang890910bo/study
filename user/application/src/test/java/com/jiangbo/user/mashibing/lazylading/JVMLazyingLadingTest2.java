package com.jiangbo.user.mashibing.lazylading;

/**
 * JVMLazyingLadingTest2
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/03/22
 */
public class JVMLazyingLadingTest2 {

	public static void main(String[] args) {

		//308300
		for (int i = 0; i < 100000; i++) {
			m();
		}

		//3681600
		long start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			m();
		}
		System.out.println(System.nanoTime() - start);
	}

	public static void m(){
		for (int i = 0; i < 100000; i++) {
			long j = i %3;
		}
	}




}
