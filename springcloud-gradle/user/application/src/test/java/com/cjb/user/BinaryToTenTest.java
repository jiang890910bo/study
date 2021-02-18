package com.cjb.user;

/**
 * BinaryToTenTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/05
 */
public class BinaryToTenTest {

  public static void main(String[] args) {
    /**
     * 十进制转成十bai六进制：
     * Integer.toHexString(int i)
     */
    System.out.println("十进制数转十六进制：" + Integer.toHexString(9));
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
    * 十六进dao制转成十进制
    * Integer.valueOf("FFFF",16).toString()
    */
     System.out.println("十六进制数FFFF转十进制：" + Integer.valueOf("FFFF",16));
     /**
     * 八进制转成十进制
     * Integer.valueOf("876",8).toString()
      */
    System.out.println("八进制数76转成十进制：" + Integer.valueOf("76",8));
    /**
    * 二进制转十进制
    * Integer.valueOf("0101",2).toString()
     */
     System.out.println("二进制数0101转十进制:" + Integer.valueOf("10",2));

    /**
     * 有什么方法可以直接将2,8,16进制直接转换为10进制的吗?
     * java.lang.Integer类
     * parseInt(String s, int radix)
     * 使用第二个参数指定的基数，将字符串参数解析为有符号的整数。
     */
    System.out.println(Integer.parseInt("0011", 2));// returns 3
    System.out.println(Integer.parseInt("0", 10));// returns 0
    System.out.println(Integer.parseInt("473", 10));// returns 473
    System.out.println(Integer.parseInt("-0", 10));// returns 0
    System.out.println(Integer.parseInt("-FF", 16));// returns -255
    System.out.println(Integer.parseInt("1100110", 2));// returns 102
    System.out.println(Integer.parseInt("2147483647", 10));// returns 2147483647
    System.out.println(Integer.parseInt("-2147483648", 10));// returns -2147483648
    //System.out.println(Integer.parseInt("2147483648", 10));// throws a NumberFormatException
    System.out.println(Integer.parseInt("99"));//, throws a NumberFormatException
    //System.out.println(Integer.parseInt("Kona", 10));// throws a NumberFormatException
    System.out.println(Integer.parseInt("Kona", 27));// returns 411787
  }



  /**
   * 检查是否是数字
   * @param number
   */
  public static void checkNumber(String number) {
    String regexp = "^\\d+$";
    if (null == number || !number.matches(regexp)) {
      throw new IllegalArgumentException("input is not a number");
    }
  }
}
