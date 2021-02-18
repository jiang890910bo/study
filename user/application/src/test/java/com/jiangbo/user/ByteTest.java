package com.jiangbo.user;

import java.time.Instant;

/**
 * ByteTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/09/28
 */
public class ByteTest {
  public static void main(String[] args) {
    System.out.println("Hi:".getBytes().length);
    System.out.println("中国".getBytes().length);
    System.out.println("中国".getBytes().length);
    System.out.println(("\"driverNo\":\"223111081290199041\",\"orderNo\":null,\"monitorStatus\":0,\"lon\":120.121185,\"lat\":30.279509").getBytes().length);

    Byte a = 127;
    Byte b = 127;
    if(a == b) {
      System.out.println(a == b);
    }


	  long locateTime = Instant.now().toEpochMilli() + 60001;
	  if(locateTime -  Instant.now().toEpochMilli() > 60000){
		  System.out.println("过滤超过{}毫秒的经纬度消息");
		  return;
	  }
  }
}
