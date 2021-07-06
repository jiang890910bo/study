package com.jiangbo.user.current;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * BaseTask
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/03/17
 */
public class BaseTask implements Runnable{

	private List<MyObject> myObjectList;

	/**
	 * 是否上报成功
	 */
	AtomicBoolean isSuccess = new AtomicBoolean(false);

	public void setMyObjectList(List<MyObject> list){
		myObjectList = list;
	}

	@Override
	public void run() {
		myObjectList.stream().forEach(o ->{
			System.out.println(o);
		});
	}
}
