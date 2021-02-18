package com.jiangbo.user;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ListStreamTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/12/29
 */
@Slf4j
public class ListStreamTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("0");
		list.add("2");
		list.add("3");
		list.add("4");

		list.stream().filter(var -> ListStreamTest.filter(var)).forEach(var ->{
			try {
				System.out.println(var);
				int i = 0/Integer.parseInt(var);
			} catch (Exception e) {
				log.error("exception: ", e);
				return;
			}
		});
	}

	public static boolean filter(String var){
		if(var.equals("2")){
			return false;
		}
		return true;
	}
}
