package com.jiangbo.user;

import io.swagger.models.auth.In;

/**
 * BinaryconvertTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/25
 */
public class BinaryconvertTest {
  public static void main(String[] args) {
    /**
     * 十进制转十六进制：
     * Integer.toHexString(int i)
     */
    System.out.println("十进制数9转十六进制：" + Integer.toHexString(9));
    /**
     * 十进制转成八进制
     * Integer.toOctalString(int i)
     */
    System.out.println("十进制数9转八进制：" + Integer.toOctalString(9));
    /**
     * 十进制转成二进制
     * Integer.toBinaryString(int i)
     */
    System.out.println("十进制数3转二进制：" + Integer.toBinaryString(3));
    /**
     * 十六进制转成十进制
     * Integer.valueOf(String str, int radix)
     */
    System.out.println("十六进制数FFFF转十进制：" + Integer.valueOf("FFFF",16));
    /**
     * 八进制转成十进制
     * Integer.valueOf(String str, int radix)
     */
    System.out.println("八进制数76转成十进制：" + Integer.valueOf("76",8));
    /**
     * 二进制转十进制
     * Integer.valueOf(String str, int radix)
     */
    System.out.println("二进制数0101转十进制:" + Integer.valueOf("10",2));


    //将其他进制转换为10进制 ，默认只能转2~36 进制(Character.MIN_RADIX=2, Character.MAX_RADIX=36),超出转换范围报错.

    // 二进制转换十进制
    System.out.println(Integer.parseInt("0011", 2));// return 3
    // 十进制转换十进制
    System.out.println(Integer.parseInt("473", 10));// return 473
    // 16进制转换十进制
    System.out.println(Integer.parseInt("-FF", 16));// return -255
    // 二进制转换十进制
    System.out.println(Integer.parseInt("1100110", 2));// return 102
    // 8进制转换十进制
    System.out.println(Integer.parseInt("36432", 8));//return 15642
    // 27进制转换十进制
    System.out.println(Integer.parseInt("Kona", 27));// return 411787

    System.out.println(Integer.parseInt("01", 2));
    System.out.println(Integer.parseInt("0001", 2));
    System.out.println(Integer.parseInt("10", 2));
  }
}
