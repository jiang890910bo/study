package com.jiangbo.user.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Test
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/06/12
 * @Version 1.0.0
 */
@Data
@Table(name = "account")
public class Account {

  @GeneratedValue(generator = "JDBC")
  @Id
  @Column(name="id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private Integer age;

  @Column(name = "deposit")
  private Float deposit;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name="update_time")
  private Date updateTime;

	@Column(name="seq")
	private String seq;

  private List<Long> idList;
}
