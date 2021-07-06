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
public class TaskB extends BaseTask {

	public void init(){
		List<MyObject> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			MyObject myObject = new MyObject();
			myObject.setName("物体B" + i);
			list.add(myObject);

			setMyObjectList(list);
		}

	}
}
