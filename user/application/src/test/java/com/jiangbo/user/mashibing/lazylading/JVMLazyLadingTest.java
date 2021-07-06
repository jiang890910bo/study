package com.jiangbo.user.mashibing.lazylading;

/**
 * JVMLazyLadingTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/03/22
 */
public class JVMLazyLadingTest {

	public static void main(String[] args) {
		//没有new没有访问不会加载
		//P p;

		//new了会被加载
		//X x = new X();

		//打印final修饰的变量不需要加载这个类
		//System.out.println(P.j);

		//打印非final会加载这个类
		//System.out.println(P.i);

		//通过反射加载, 类会被加载
		try {
			Class.forName("com.jiangbo.user.mashibing.lazylading.JVMLazyLadingTest$P");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static class P{
		private final  static  int j = 8;
		private static int i = 1;
		static{
			System.out.println("P");
		}

	}

	static class X extends P{
		static{
			System.out.println("X");
		}
	}
}
