package com.cjb.user.domain;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

/**
 * TeacherService
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/02
 */
@Component
public class TeacherService implements UserInterface {
  @Override
  public String say(String words) {
    return "老师：" + words;
  }
}
