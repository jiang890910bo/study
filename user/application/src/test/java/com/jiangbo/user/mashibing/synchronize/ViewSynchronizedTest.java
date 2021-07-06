package com.jiangbo.user.mashibing.synchronize;

/**
 * ViewSynchronizedTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/03/07
 */
public class ViewSynchronizedTest {
//	public static synchronized void test(){
//		System.out.println("test");
//	}

	public static void main(String[] args) {
		int a = 8;
		a = a++;
		System.out.println(a);
	}

}
