package com.jiangbo.user.mashibing.concurrentcontainers;

import java.util.HashMap;

/**
 * 测试hashtable线程安全
 * 相关博客：https://my.oschina.net/hosee/blog/673521
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/22
 */
public class HashMapTest {
//	static Map<String, Integer> hashMap = Collections.synchronizedMap(new HashMap<>());
	static HashMap<String, Integer> hashMap = new HashMap<>();

	public static void main(String[] args) {
		Thread threadOne = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				hashMap.put("thread1_" + i, i);
			}
		});

		Thread threadTwo = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				hashMap.put("thread2_" + i, i);
			}
		});

		threadOne.start();
		threadTwo.start();


		try {
			threadOne.join();
			threadTwo.join();

			System.out.println(hashMap.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
