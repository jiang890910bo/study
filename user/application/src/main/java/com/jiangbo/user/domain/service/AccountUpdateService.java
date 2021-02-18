package com.jiangbo.user.domain.service;

import com.jiangbo.user.domain.entity.Account;
import com.jiangbo.user.gateway.acl.repositories.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * AccountCreateService
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */
@Component
public class AccountUpdateService {

  @Autowired
  private AccountMapper accountMapper;

  public int update(Account account){
    return accountMapper.updateByPrimaryKey(account);
  }

  public int batchUpdate(Account account){
      return accountMapper.batchUpdate(account);
  }

  public int updateByName(Account account){
    return accountMapper.updateByName(account);
  }

  public int updateByAge(Account account){
    return accountMapper.updateByAge(account);
  }

}
