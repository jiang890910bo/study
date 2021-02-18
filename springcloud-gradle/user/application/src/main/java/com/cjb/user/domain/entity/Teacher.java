package com.cjb.user.domain.entity;

import lombok.Data;

/**
 * Teacher
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/02
 */
@Data
public class Teacher extends User {
  String  teachingSubject;
}
