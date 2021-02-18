package com.jiangbo.user;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MapDivisor
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/09/14
 */
public class MapDivisor {
  public static void main(String[] args) {
    Map<String, String> map = new ConcurrentHashMap<>(3);
    for(int i = 0; i<20 ; i ++){
      map.put("key" + i, "value" + i);
    }

    System.out.println(map);
  }
}
