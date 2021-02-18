package com.jiangbo.user;

import com.alibaba.fastjson.JSON;
import org.apache.tomcat.jni.Time;

import java.time.Instant;
import java.util.Calendar;

/**
 * CharsetConvert
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/09/08
 */
public class CharsetConvert {
  public static void main(String[] args) {
    String value = "{\\\"driver_is_assign\\\":1,\\\"is_busy\\\":0,\\\"listen_mode\\\":1,\\\"product_type\\\":\\\"express-car\\\",\\\"receive_level\\\":[{\\\"product_type\\\":\\\"express-car\\\",\\\"ride_type\\\":\\\"express\\\"}],\\\"ride_type\\\":\\\"express\\\"}";
    String string = JSON.toJSONString(value).replaceAll("\\\\", "");
    System.out.println(string);

    System.out.println(Instant.now().getEpochSecond());
  }
}
