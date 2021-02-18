package com.jiangbo.user.gateway.acl.algorithm;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;

/**
 * @program: order
 * @description: 雪花算法key
 * @author: Jason
 * @date: 2019-12-19 16:22
 **/
@SuppressWarnings("all")
@UtilityClass
public class SnowflakeKeyHashUtil {

  public static int keyHash(String key) {
    final int p = 16777619;
    long hash = (int) 2166136261L;
    for (int i = 0, n = key.length(); i < n; i++) {
      hash = (hash ^ key.charAt(i)) * p;
    }
    hash += hash << 13;
    hash ^= hash >> 7;
    hash += hash << 3;
    hash ^= hash >> 17;
    hash += hash << 5;
    return ((int) hash & 0x7FFFFFFF);
  }

  public static int getShardingKey4YM(String key) {
    LocalDate date = SnowFlakeParseUtils.getDate(key);
    int month = date.getMonth().getValue();
    int year = date.getYear();
    return Integer.parseInt(String.format("%s%s", year, month >= 10 ? String.valueOf(month) : "0" + month));
  }

  public static int getShardingKey4Hash(String key, int tableCount) {
    int hash = keyHash(key);
    return hash % tableCount + 1;
  }
}
