package com.jiangbo.user.current;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskA
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/03/17
 */
public class TaskA extends BaseTask {

	public void init(){
		List<MyObject> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			MyObject myObject = new MyObject();
			myObject.setName("物体A" + i);
			list.add(myObject);

			setMyObjectList(list);

			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
