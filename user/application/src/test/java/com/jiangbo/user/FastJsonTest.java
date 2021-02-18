package com.jiangbo.user;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * FastJsonTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/12/01
 */
public class FastJsonTest {
  public static void main(String[] args) {
    Person person = new Person();
    person.setName("cjb");
    System.out.println(JSON.toJSONString(person));
  }

  @ToString
  @Setter
  @Getter
  static class Person{
    private String name;
    private Integer age;
  }
}
