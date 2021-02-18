package com.jiangbo.user;

import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64Test
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/22
 */
public class Base64Test {
  public static void main(String[] args) {
//    System.out.println("===============sun.misc.BASE64Encoder=======================");
//    //以前使用Base64编码/解码
//    final BASE64Encoder encoder = new BASE64Encoder();
//    final BASE64Decoder decoder = new BASE64Decoder();
//    //编码
//    String text = "字符串、Hello, word";
//    String encoderText = encoder.encode(text.getBytes());
//    System.out.println(encoderText);
//    //解码
//    try {
//      byte[] bytes = decoder.decodeBuffer(encoderText);
//      System.out.println(new String(bytes, "UTF-8"));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

    System.out.println("================Apache：commons-codec:org.apache.commons.codec.binary.Base64======================");
    final org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
    String text1 = "字符串、Hello, word";
    //编码
    byte[] bytes = base64.encode(text1.getBytes());
    System.out.println(bytes);
    String encodeValue = base64.encodeToString(text1.getBytes());
    System.out.println(encodeValue);
    //解码
    byte[] decode = base64.decode(encodeValue);
    try {
      System.out.println(new String(decode, "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    System.out.println("================jdk1.8:java.util.Base64======================");
    //java8 使用
    Base64.Encoder encoder1 = Base64.getEncoder();
    Base64.Decoder decoder1 = Base64.getDecoder();
    //编码
    String text2 = "字符串、Hello world";
    String encodeValue2 = encoder1.encodeToString(text2.getBytes());
    System.out.println(encodeValue2);
    //解码
    byte[] decode2 = decoder1.decode(encodeValue2);
    try {
      System.out.println(new String(decode2, "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    System.out.println("================spring-core:org.springframework.util.Base64Utils======================");
    String text4 = "字符串|Hello world";
    //编码
    String encodeValue4 = Base64Utils.encodeToString(text4.getBytes());
    System.out.println(encodeValue4);
    //解码
    byte[] bytes4 = Base64Utils.decodeFromString(encodeValue4);
    try {
      System.out.println(new String(bytes4, "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

  }
}
