package com.jiangbo.user.gateway.acl.algorithm;

import java.util.Calendar;

/**
 * SnowFlakeConstant
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/12/15
 */
public final class SnowFlakeConstant {
	/**
	 * 起始的时间戳(当前较近的时间戳)
	 */
	public static final long EPOCH;

	/**
	 * 每一部分占用的位数, 序列号占用的位数
	 */
	public static final long SEQUENCE_BIT = 12;

	public static final long SEQUENCE_MASK = (1 << SEQUENCE_BIT) - 1;

	/**
	 * 每一部分占用的位数, 机器标识占用的位数
	 */
	public static final long WORK_ID_BIT = 10;

	/**
	 * 每一部分的最大值
	 */
	public static final long MAX_MACHINE_NUM = -1L ^ (-1L << WORK_ID_BIT);

	/**
	 * 每一部分向左的位移
	 */
	public static final long WORK_ID_LEFT_SHIFT_BITS = SEQUENCE_BIT;
	public static final long TIMESTAMP_LEFT = SEQUENCE_BIT + WORK_ID_BIT;
	public static final long TIMESTAMP_LEFT_SHIFT_BITS = WORK_ID_LEFT_SHIFT_BITS + WORK_ID_BIT;

	/**
	 * 从2019年1月1日开始
	 */
	static {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, Calendar.JANUARY, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		EPOCH = calendar.getTimeInMillis();
	}
}
