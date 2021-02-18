package com.jiangbo.user.mashibing.staticTest;

/**
 * StaticTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/16
 */
public class StaticTest {

	static int num = 0;
	static{
		System.out.println("静态块");
	}

	public static void function(){
		System.out.println("静态方法");
	}

	public static void main(String[] args) {
		SubClass  subClass = new SubClass();
		System.out.println(subClass.sumNum);
		System.out.println(subClass.sumNum);
	}

}
