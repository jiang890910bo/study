package com.jiangbo.user;

import lombok.extern.slf4j.Slf4j;

/**
 * ExceptionTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/12/14
 */
@Slf4j
public class ExceptionTest {
	public static void main(String[] args) {
		try {
			System.out.println("开始。。。");
			int i = 1/0;
		} catch (Exception e) {
			log.info("exception:{}", 1, e);
		}


	}
}
