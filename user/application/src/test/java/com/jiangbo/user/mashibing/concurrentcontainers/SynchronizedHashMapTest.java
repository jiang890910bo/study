package com.jiangbo.user.mashibing.concurrentcontainers;

import com.google.common.collect.Table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 测试SynchronizedHashMap线程安全
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/22
 */
public class SynchronizedHashMapTest {
		static Map<String, Integer> hashMap = Collections.synchronizedMap(new HashMap<>());
//	static Map<String, Integer> hashMap = new HashMap<>();
//	static Map<String, Integer> hashMap = new Hashtable<>();

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
