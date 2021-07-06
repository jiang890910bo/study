package com.jiangbo.user.current;

import lombok.Data;

/**
 * MyObject
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/03/17
 */
@Data
public class MyObject {

	private String name;

	@Override
	public String toString() {
		return "MyObject{" +
				"name='" + name + '\'' +
				'}';
	}
}
