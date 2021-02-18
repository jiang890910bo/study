package com.jiangbo.user.enums;

/**
 * AccountEnum
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/15
 */
public enum AccountEnum {

  CHENGJIANGBO(1L, "cjb"),
  HANGMENGXIAN(2L, "hmx"),
  CHENGJUNHAN(3L, "cjh");

  private Long id;

  private String name;

  AccountEnum(Long id, String name){
    this.id = id;
    this.name = name;
  }

  public void setId(Long id){
    this.id = id;
  }

  public Long getId(){
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
