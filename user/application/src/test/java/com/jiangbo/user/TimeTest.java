package com.jiangbo.user;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * TimeTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/03/15
 */
public class TimeTest {
	public static void main(String[] args) {
		long time = 1615797677097L;

		Instant instant = Instant.ofEpochMilli(time);
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
		System.out.println(sdf.format(date));
	}
}
