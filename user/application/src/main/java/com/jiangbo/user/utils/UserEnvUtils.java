package com.jiangbo.user.utils;

import org.springframework.core.env.Environment;

/**
 * UserEnvUtils
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/07/28
 */
public class UserEnvUtils {

  private static Environment environment;

  public static void setEnvironment(Environment environment){
    UserEnvUtils.environment = environment;
  }

  public static Environment getEnvironment(){
    return environment;
  }
}
