package com.jiangbo.user;

import java.time.Instant;

/**
 * SimpleTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/01/15
 */
public class SimpleTest {
	public static void main(String[] args) {
		long locateTime = 1610682071;
		long milNowTime = Instant.now().toEpochMilli();
		long seNowTime = Instant.now().getEpochSecond();

		System.out.println("milNowTime = " + milNowTime);
		System.out.println("seNowTime = " + seNowTime);
		if(milNowTime - seNowTime > 300000){
			System.out.println(true);
		}


		long time = 1610683274000L;
		long localTime = time;
		System.out.println(localTime);
	}
}
