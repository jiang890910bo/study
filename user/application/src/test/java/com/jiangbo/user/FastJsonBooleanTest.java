package com.jiangbo.user;

import com.alibaba.fastjson.JSONObject;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * FastJsonBooleanTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/26
 */
public class FastJsonBooleanTest {
  public static void main(String[] args) {
    Object toJSON = JSONObject.toJSON(true);
    System.out.println(toJSON);

    List<String> list = Lists.newArrayList();
    list.add("a");
    list.add("b");
    System.out.println(list);

    list = list.stream().filter(str -> str.equals("a")).collect(Collectors.toList());;
    System.out.println(list);
  }
}
