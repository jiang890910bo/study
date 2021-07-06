package com.jiangbo.user.mashibing.jvm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * T15_FullGC_Problem01
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/04/05
 */
public class T15_FullGC_Problem01 {
	private static class CardInfo{
		BigDecimal price = new BigDecimal(0.0);
		String name = "张三";
		int age = 5;
		Date brithDate = new Date();

		public void m(){}
	}

	//线程池new出来
	private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(50, new ThreadPoolExecutor.DiscardOldestPolicy());

	public static void main(String[] args) throws InterruptedException {
		executor.setMaximumPoolSize(50);
		for (;;){
			modelFit();
//			Thread.sleep(1000);
		}
	}

	private static void modelFit() {
		List<CardInfo> taskList = getAllCardInfo();
		taskList.forEach(cardInfo -> {
			executor.scheduleWithFixedDelay(() ->{
				cardInfo.m();
			}, 2, 3, TimeUnit.SECONDS);
		});
	}

	private static List<CardInfo> getAllCardInfo() {
		List<CardInfo> taskList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			CardInfo info = new CardInfo();
			taskList.add(info);
		}

		return taskList;
	}
}
