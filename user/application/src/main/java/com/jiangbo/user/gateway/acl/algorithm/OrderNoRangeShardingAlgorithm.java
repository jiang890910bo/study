package com.jiangbo.user.gateway.acl.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @program: order
 * @description: 订单表分片算法，用户范围查询
 * @author: Jason
 * @date: 2019-12-19 15:22
 **/
public class OrderNoRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

  public static final int TABLE_COUNT = 32;

  @Override
  public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> shardingValue) {

    Collection<String> collect = new ArrayList<>();
    Range<Long> valueRange = shardingValue.getValueRange();
    Long start = valueRange.lowerEndpoint();
    Long end = valueRange.upperEndpoint();
    int startYM = SnowflakeKeyHashUtil.getShardingKey4YM(String.valueOf(start));
    int endYM = SnowflakeKeyHashUtil.getShardingKey4YM(String.valueOf(end));

    int startHash = SnowflakeKeyHashUtil.getShardingKey4Hash(String.valueOf(start), TABLE_COUNT);
    int endHash = SnowflakeKeyHashUtil.getShardingKey4Hash(String.valueOf(end), TABLE_COUNT);

    for (int i = startYM; i <= endYM; i = incr4YM(i)) {
      for (int j = startHash; j <= endHash; j++) {
        for (String each : collection) {
          if (each.equals(shardingValue.getLogicTableName().concat("_").concat(String.valueOf(i)).concat("-").concat(String.valueOf(j)))) {
            collect.add(each);
          }
        }
      }

    }
    return collect;
  }

  private static int incr4YM(int ym) {
    String value = String.valueOf(ym);
    int year = Integer.valueOf(value.substring(0, 4));
    int month = Integer.valueOf(value.substring(4, 6));
    if (month < 12) {
      ++month;
    } else {
      ++year;
      month = 01;
    }
    return Integer.valueOf(String.format("%04d%02d", year, month));
  }

}
