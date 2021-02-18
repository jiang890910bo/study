package com.jiangbo.user.gateway.acl.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @program: order
 * @description: 订单表分片算法, 按订单号取模
 * @author: Jason
 * @date: 2019-12-19 15:16
 **/
public class OrderNoShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

  public static final int TABLE_COUNT = 32;

  @Override
  public String doSharding(Collection<String> collection, PreciseShardingValue<Long> shardingValue) {
    Long orderNo = shardingValue.getValue();

    int key4YM = SnowflakeKeyHashUtil.getShardingKey4YM(String.valueOf(orderNo));
    int key4Hash = SnowflakeKeyHashUtil.getShardingKey4Hash(String.valueOf(orderNo), TABLE_COUNT);

    for (String each : collection) {
      if (each.equals(shardingValue.getLogicTableName().concat("_").concat(String.valueOf(key4YM)).concat("_").concat(String.valueOf(key4Hash)))) {
        return each;
      }
    }
    return null;
  }
}
