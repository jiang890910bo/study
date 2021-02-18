package com.jiangbo.user;

import java.util.Base64;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * TestRegex
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/06/23
 * @Version 1.0.0
 */
public class TestRegex {
  /**
   * 字母和数字的正则表达式
   */
  private static String REGEX_WORD_AND_NUMBER = "^[0-9]+$";
  /**
   * 老版本订单的前缀（哎吆喂的前身-》领航员）
   */
  private static String LHY_ORDER_NO_PREFIX = "ZFJC";

  public static void main(String[] args) {
//    String orderNos = "TVRrNU1qWTROdz09,TVRrNU1qUTRNdz09,T1Rnek56RTE=,ZFJC201911323351393544";
//    System.out.println(parseSpecialOrderNos(orderNos));

    System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
  }

  public static String parseSpecialOrderNos(String orderNos){
    Objects.requireNonNull(orderNos);
    String[] orderNoArray =  orderNos.split(",");
    StringBuffer resultOrderNos = new StringBuffer();
    for (String str : orderNoArray) {
      if(str.indexOf(LHY_ORDER_NO_PREFIX) != -1 && ! Pattern.matches(REGEX_WORD_AND_NUMBER, str)){
        resultOrderNos.append(str);
      }else{
        byte[] temp = Base64.getDecoder().decode(str);
        temp = Base64.getDecoder().decode(new String(temp));
        resultOrderNos.append(new String(temp));
      }
      resultOrderNos.append(",");
    }

    return resultOrderNos.delete(resultOrderNos.length()-1, resultOrderNos.length()).toString();
  }
}
