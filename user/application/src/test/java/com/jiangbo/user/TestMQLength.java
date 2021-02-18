package com.jiangbo.user;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Base64;

/**
 * TestMQLength
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/06/15
 * @Version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles
public class TestMQLength {



  public static void main(String[] args) {
//    String str = "{\"dataVersion\":\"100\",\"cityCode\":\"0571\",\"rideTypeCode\":\"1\",\"driverNo\":\"285253927878791168\",\"driverStatus\":\"2\",\"carNo\":\"浙A1KT51\",\"lon\":\"120.311544\",\"lat\":\"30.434494\",\"direction\":\"77\",\"speed\":\"14.39\",\"height\":\"9.6\",\"radius\":\"16\",\"provider\":\"1\",\"locateTime\":\"1591881945000\",\"deviceId\":\"568c45ae064b71b6\",\"phoneType\":\"A\",\"orderNo\":\"191300672896598017\",\"orderStatus\":\"1\",\"isForeground\":\"1\",\"page\":\"OrderOperationActivity\"}";
//    System.out.println(str.length() * 4);

      byte[] bytes = Base64.getDecoder().decode("TVRrNU1qVTNOZz09");
    bytes = Base64.getDecoder().decode(new String(bytes));
      System.out.println(new String(bytes));
  }
}
