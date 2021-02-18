package com.jiangbo.user;

import com.alibaba.fastjson.JSONObject;

/**
 * TestJsonProperty
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/09/01
 */
public class TestJsonProperty {
  public static void main(String[] args) {
    OrderEstimateEventRequest orderEstimateEventRequest = new OrderEstimateEventRequest();
    orderEstimateEventRequest.setCityCode("0571");
    System.out.println(JSONObject.toJSONString(orderEstimateEventRequest));
    long time = System.currentTimeMillis();
  }
}
