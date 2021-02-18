package com.jiangbo.user;

/**
 * ThreadUseTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/01/14
 */
public class ThreadUseTest {
	public static void main(String[] args) throws InterruptedException {
		Person person = new Person();
		person.setName("程江波");

		Thread thread  = new Thread(()->{
			new ThreadUseTest().threadTest(person.getName());
		});
		thread.start();
		thread.join();

		try {
			//Thread.sleep(1L);
			person.setName("楼宁峰");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void threadTest(String name){
		try {
			System.out.println(name);
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
