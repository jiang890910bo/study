package com.jiangbo.user.application.assembler;

import com.jiangbo.user.domain.entity.Account;
import com.jiangbo.user.gateway.ohs.vo.request.AccountRequest;
import com.jiangbo.user.gateway.ohs.vo.request.UpdateAccountRequest;
import com.jiangbo.user.gateway.ohs.vo.request.UpdateByConditionRequest;
import com.jiangbo.user.gateway.ohs.vo.response.AccountResponse;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * AccountAssembler
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */
public class AccountAssembler {

  public static void requestToEntity(AccountRequest request, Account account){
    BeanUtils.copyProperties(request, account);
    account.setCreateTime(new Date());
    account.setUpdateTime(new Date());
  }

  public static void entityToResponse(Account account, AccountResponse response) {
    BeanUtils.copyProperties(account, response);
  }

  public static void updateRequestToEntity(UpdateAccountRequest request, Account account) {
    BeanUtils.copyProperties(request, account);
    account.setUpdateTime(new Date());
    account.setUpdateTime(new Date());
  }

  public static void updateByConditionRequestToEntity(UpdateByConditionRequest request, Account account) {
    BeanUtils.copyProperties(request, account);
    account.setUpdateTime(new Date());
  }
}
