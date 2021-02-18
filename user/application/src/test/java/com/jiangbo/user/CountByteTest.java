package com.jiangbo.user;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * CountByteTest
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/11/10
 */
public class CountByteTest {
  public static void main(String[] args) {
//    String jsonValue = "{\"appId\":\"1021\",\"carNo\":\"云D5S032\",\"cityCode\":\"0874\",\"driverNo\":\"241829350168141824\",\"driverStatus\":0,\"lat\":26.220273,\"locateTime\":1605005009000,\"lon\":104.095604,\"monitorStatus\":0,\"rideTypeCode\":\"1\"}";
//    System.out.println(jsonValue.getBytes().length);
//    System.out.println("A".getBytes().length);

    List<User> list = new ArrayList<>();
    list.add(new User("江波", 31));
    list.add(new User("江波1", 31));
    list.add(new User("江波2", 31));
    list.add(new User("江波1", 31));
    list.add(new User("江波", 34));

//    List<String> stringList = list.stream().map(User::getName).collect(Collectors.toList());

    list =list.stream().distinct().collect(Collectors.toList());
//
    list.stream().forEach(str ->{
      System.out.println(str);
    });
  }

  @Data
  @ToString
  static  class User{
    private String name;
    private Integer age;

    User(String name, Integer age){
      this.age  = age;
      this.name = name;
    }


    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
       if(Objects.equals(name, user.name)){
         return this.age + 3> user.age;
       }

      return false;
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, age);
    }
  }
}
