package com.jiangbo.user.gateway.ohs.vo.response;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * AccountResponse
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */
@Data
public class AccountResponse {

  private String name;

  private Integer age;

  private Float deposit;

  private Date createTime;

  private Date updateTime;
}
