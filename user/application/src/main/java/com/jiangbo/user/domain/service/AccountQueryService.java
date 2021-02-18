package com.jiangbo.user.domain.service;

import com.jiangbo.user.domain.entity.Account;
import com.jiangbo.user.gateway.acl.repositories.AccountMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * AccountCreateService
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */
@Component
public class AccountQueryService {

  @Resource
  private AccountMapper accountMapper;

  /**
   * 根据id查询对象
   * @param id
   * @return
   */
  public  Account queryById(Long id){
    return accountMapper.selectByPrimaryKey(id);
  }

  public List<Account> queryByCondition(Account account){

     return accountMapper.selectByExample(account);
  }
}
