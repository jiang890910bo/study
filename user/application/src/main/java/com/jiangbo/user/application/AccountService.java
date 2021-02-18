package com.jiangbo.user.application;

import com.alibaba.fastjson.JSON;
import com.jiangbo.user.application.assembler.AccountAssembler;
import com.jiangbo.user.domain.entity.Account;
import com.jiangbo.user.domain.service.AccountCreateService;
import com.jiangbo.user.domain.service.AccountQueryService;
import com.jiangbo.user.domain.service.AccountUpdateService;
import com.jiangbo.user.gateway.ohs.vo.request.AccountRequest;
import com.jiangbo.user.gateway.ohs.vo.request.UpdateAccountRequest;
import com.jiangbo.user.gateway.ohs.vo.response.AccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * AccountService
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/23
 * @Version 1.0.0
 */
@Slf4j
@Component
public class AccountService {

  @Autowired
  private AccountCreateService accountCreateService;

  @Autowired
  private AccountQueryService accountQueryService;

  @Autowired
  private AccountUpdateService accountUpdateService;

  public void create(AccountRequest request){
    Account account = new Account();
    AccountAssembler.requestToEntity(request, account);
    if(accountCreateService.add(account) == 1){
      log.info("添加成功.");
    }else{
      log.warn("添加失败.");
    }
  }

  /**
   * 根据id查询对象
   * @param accountId
   * @return
   */
  public AccountResponse queryById(Long accountId){
    AccountResponse response = new AccountResponse();
    Account account = accountQueryService.queryById(accountId);
    AccountAssembler.entityToResponse(account, response);

    return response;
  }


  /**
   * 根据id更新对象
   *
   */
  @Transactional(rollbackFor = Exception.class)
  public void updateById1(UpdateAccountRequest request){
    Account account = new Account();
    AccountAssembler.updateRequestToEntity(request, account);
    int result = accountUpdateService.batchUpdate(account);
    if (result > 0) {
      log.info("updateById1->accountUpdateService 修改成功:{}", result);
    } else {
      log.warn("updateById1->accountUpdateService 修改失败: {}.", JSON.toJSONString(request));
    }

  }

  /**
   * 根据id更新对象
   *
   */
  @Transactional(rollbackFor = Exception.class)
  public void updateById2(UpdateAccountRequest request){
    Account account = new Account();
    AccountAssembler.updateRequestToEntity(request, account);


    int result = accountUpdateService.batchUpdate(account);
    if (result > 0) {
      log.info("updateById2->accountUpdateService 修改成功:{}.", result);
    } else {
      log.warn("updateById2->accountUpdateService 修改失败: {}.", JSON.toJSONString(request));
    }

  }

  @Transactional(rollbackFor = Exception.class)
  public void batchUpdate(UpdateAccountRequest updateAccountRequest) throws InterruptedException {
    Objects.requireNonNull(updateAccountRequest, "参数 requestList");
    Account account = new Account();
    BeanUtils.copyProperties(updateAccountRequest, account);
    accountUpdateService.batchUpdate(account);
    //Thread.sleep(60000L);
    //int i = 1/0;
  }

  @Transactional(rollbackFor = Exception.class)
  public void updateByName(UpdateAccountRequest updateAccountRequest) throws InterruptedException {
    Objects.requireNonNull(updateAccountRequest, "参数 updateAccountRequest");
    Account account = new Account();
    BeanUtils.copyProperties(updateAccountRequest, account);
    accountUpdateService.updateByName(account);
  }

  @Transactional(rollbackFor = Exception.class)
  public void updateByAge(UpdateAccountRequest updateAccountRequest) throws InterruptedException {
    Objects.requireNonNull(updateAccountRequest, "参数 updateAccountRequest");
    Account account = new Account();
    BeanUtils.copyProperties(updateAccountRequest, account);
    accountUpdateService.updateByAge(account);
  }
}
