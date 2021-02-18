package com.jiangbo.user.gateway.acl.algorithm;

/**
 * SnowFlakeParseUtils
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/12/15
 */

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static com.jiangbo.user.gateway.acl.algorithm.SnowFlakeConstant.TIMESTAMP_LEFT;
import static org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator.EPOCH;

/**
 * @author jarck-lou
 * @date 2019/09/04 11:48
 **/
public final class SnowFlakeParseUtils {
	/**
	 * 解析出生成日期
	 *
	 * @param uid 雪花算法生成ID
	 * @return localDate
	 */
	public static LocalDate getDate(long uid) {
		String snowFlakeId = Long.toBinaryString(uid);

		int len = snowFlakeId.length();
		int timeEnd = (int) (len < TIMESTAMP_LEFT ? 0 : len - TIMESTAMP_LEFT);

		String time = snowFlakeId.substring(0, timeEnd);

		long diffTime = Long.parseLong(time, 2);
		long timeLong = EPOCH + diffTime;

		return Instant.ofEpochMilli(timeLong).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * 解析出生成日期
	 *
	 * @param uidStr 雪花算法生成ID
	 * @return localDate
	 */
	public static LocalDate getDate(String uidStr) {
		return getDate(Long.parseLong(uidStr));
	}
}

