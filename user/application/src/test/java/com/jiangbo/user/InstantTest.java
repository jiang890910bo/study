package com.jiangbo.user;

import java.time.Instant;

/**
 * InstantTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/09/16
 */
public class InstantTest {
  public static void main(String[] args) {
    System.out.println(Instant.now());
    String appIdString = "123"+ "_" + "abc"+ "_" + "werwer";
    System.out.println(appIdString.substring(0, appIdString.indexOf("_")));
  }
}
