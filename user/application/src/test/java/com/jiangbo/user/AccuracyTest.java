package com.jiangbo.user;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AccuracyTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/13
 */
@Slf4j
public class AccuracyTest {
  public static void main(String[] args) {
    System.out.println(Math.round(17.24 * 100));
    System.out.println(Math.round(17.26* 100));
    System.out.println(Math.round(0.29* 100));
    System.out.println(Math.round(17.21* 100));

    Double aDouble = new Double("17.24");
    //Double调用intValue()是四舍五入向下取整
    System.out.println(aDouble.doubleValue());
    //调用doubleValue()才是取double真实值
    System.out.println(aDouble.intValue());

    DateTimeFormatter yyyy_mm_dd = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    System.out.println(LocalDateTime.now().format(yyyy_mm_dd));

    List<String> stringList = new ArrayList<String>();
    stringList.add("123");
    stringList.add("456");
    stringList.forEach(str ->{
//      if(str.equals("123")){
//        return;
//      }
      System.out.println(str);
    });

    System.out.println(JSONObject.toJSONString(stringList));


    System.out.println(Objects.isNull("[]"));


    try {
      Integer num = null;
      switch (num){
        case 1:
        case 2:
          System.out.println("a");
      }
    } catch (Exception e) {
      log.info("{}", e);
    }

  }


}
