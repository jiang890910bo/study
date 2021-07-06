package com.jiangbo.user;

/**
 * TryCatchFinallyTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/20
 */
public class TryCatchFinallyTest {
	public static void main(String[] args) {
		try {
			System.out.println("执行1/0前");
			int i = 1/0;
			System.out.println("执行1/0后");
		} catch (Exception e) {
			System.out.println("执行catch");
			e.printStackTrace();
		} finally {
			System.out.println("调用finally");
		}
	}
}
