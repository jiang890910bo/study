package com.jiangbo.user;

import org.apache.commons.lang3.StringUtils;

/**
 * BlankStringTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/09/14
 */
public class BlankStringTest {

  public static void main(String[] args) {
    String assignDriverId = null;
    if (StringUtils.isNotBlank(assignDriverId)) {
      //模拟滴滴的指定司机派单
      System.out.println(assignDriverId);
    }else{
      System.out.println("assignDriverId为空");
    }
  }
}
