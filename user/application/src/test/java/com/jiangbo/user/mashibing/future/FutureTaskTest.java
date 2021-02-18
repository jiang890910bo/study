package com.jiangbo.user.mashibing.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask: 它是Future加上Runnable, 既可以执行又可以存结果。
 * FutureTask实现了RunnableFuture, 而RunnableFuture即实现了Runnable又实现类Future, 所以它既是一个任务又是一个Future.
 *
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/17
 */
public class FutureTaskTest {
	public static void main(String[] args) {
		FutureTask task = new FutureTask<Integer>(()->{
			Thread.sleep(500);
			return 1000;
		});

		new Thread(task).start();

		try {
			System.out.println(task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
