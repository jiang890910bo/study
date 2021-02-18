package com.jiangbo.user.domain.service;

import com.jiangbo.user.domain.entity.Account;
import com.jiangbo.user.gateway.acl.repositories.AccountMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * AccountCreateService
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */
@Component
public class AccountCreateService {

  @Resource
  private AccountMapper accountMapper;

  /**
   * 插入数据
   * @param account
   * @return
   */
  public  int add(Account account){
    return accountMapper.insert(account);
  }
}
