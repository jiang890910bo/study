package com.jiangbo.user.mashibing.future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFutureTask
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/02/17
 */
public class CompletableFutureTask {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		CompletableFuture<Double> priceOfTM = CompletableFuture.supplyAsync(()->priceOfTM());
		CompletableFuture<Double> priceOfTB = CompletableFuture.supplyAsync(()->priceOfTB());
		CompletableFuture<Double> priceOfPDD = CompletableFuture.supplyAsync(()->priceOfPDD());

		//CompletableFuture.allOf(priceOfTM, priceOfTB, priceOfPDD).join();//等待里面的任务全部完成，才有结果
		CompletableFuture.anyOf(priceOfTM, priceOfTB, priceOfPDD).join();//只要其中一个任务完成，就可以获得结果
		long endTime = System.currentTimeMillis();


		try {
			System.out.println("TM: "+priceOfTM.get()+ "  TB:"+ priceOfTB.get()+ "  PDD:"+ priceOfPDD.get() +"\n use completable future, " +(endTime - startTime)+ "ms");

			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}


	}

	public static Double priceOfTM(){
		delay();
		return 1000.00;
	}

	public static Double priceOfTB(){
		delay();
		return 800.00;
	}

	public static Double priceOfPDD(){
		delay();
		return 500.00;
	}

	public static void delay(){
		int time = new Random().nextInt(5);
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("After %s sleep! \n", time);
	}

}
