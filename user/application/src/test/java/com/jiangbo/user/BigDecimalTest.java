package com.jiangbo.user;

import java.math.BigDecimal;

/**
 * BigDecimalTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/12/07
 */
public class BigDecimalTest {
  public static void main(String[] args) {
    BigDecimal decimal = new BigDecimal(9.9119999999999994777510892163263444520619380257947951185144332131304878430455573834478855133056640625);
    BigDecimal value = null;
    value = decimal.setScale(2, BigDecimal.ROUND_FLOOR);//向下舍位
    System.out.println(value);
    value = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);//四舍五入
    System.out.println(value);
    value = decimal.setScale(2, BigDecimal.ROUND_HALF_DOWN);//五舍六入
    System.out.println(value);
    value = decimal.setScale(2, BigDecimal.ROUND_CEILING);//向上进位
    System.out.println(value);
    value = decimal.setScale(2, BigDecimal.ROUND_UP);//绝对值向上进位
    System.out.println(value);
  }
}
