package com.cjb.user.domain;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

/**
 * StudentService
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/02
 */
@Component
public class StudentService implements UserInterface {
  @Override
  public String say(String words) {
    return "学生：" + words;
  }
}
