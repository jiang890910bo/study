package com.jiangbo.user.application;

import com.google.common.collect.Lists;
import com.jiangbo.user.gateway.ohs.vo.request.UpdateAccountRequest;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DemoGlueJobHander
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/30
 */
@Slf4j
@Component
public class DemoJobHandler {

  @Autowired
  private AccountService accountService;

  //@XxlJob(value = "updateById1JobHandler")
  public ReturnT<String> updateById1JobHandler(String param) throws Exception {
    log.info("updateById1JobHandler begin......");

    try {
      UpdateAccountRequest accountRequest = new UpdateAccountRequest();
      accountRequest.setIdList(Lists.newArrayList(1L, 2L));
      accountRequest.setDeposit(3000f);
      accountService.updateById1(accountRequest);
    } catch (Exception e) {
      log.error("exception:{}", e);
    }

    log.info("updateById1JobHandler end......");
    return ReturnT.SUCCESS;
  }

  //@XxlJob(value = "updateById2JobHandler")
  public ReturnT<String> updateById2JobHandler(String param) throws Exception {
    log.info("updateById2JobHandler begin......");

    try {
      UpdateAccountRequest accountRequest = new UpdateAccountRequest();
      accountRequest.setIdList(Lists.newArrayList(1L, 2L));
      accountRequest.setDeposit(3000f);
      accountService.updateById2(accountRequest);
    } catch (Exception e) {
      log.error("exception:{}", e);
    }

    log.info("updateById2JobHandler end......");
    return ReturnT.SUCCESS;
  }

//  @XxlJob(value = "batchUpdateJobHandler")
//  public ReturnT<String> execute2(String param) throws Exception {
//    log.info("updateJobHandler begin......");
//    try {
//      UpdateAccountRequest accountRequest = new UpdateAccountRequest();
//      accountRequest.setIdList(Lists.newArrayList(3L, 4L));
//      accountRequest.setDeposit(3000f);
//      accountService.batchUpdate(accountRequest);
//    } catch (Exception e) {
//      log.error("exception:{}", e);
//    }
//    log.info("updateJobHandler end......");
//    return ReturnT.SUCCESS;
//  }

  @XxlJob(value = "updateByAgeJobHandler")
  public ReturnT<String> updateByAgeJobHandler(String param) throws Exception {
    log.info("updateByAgeJobHandler begin......");
    try {
      UpdateAccountRequest accountRequest = new UpdateAccountRequest();
      accountRequest.setDeposit(110f);
      accountRequest.setAge(5);
      accountService.updateByAge(accountRequest);
    } catch (Exception e) {
      log.error("exception:{}", e);
    }
    log.info("updateByAgeJobHandler end......");
    return ReturnT.SUCCESS;
  }

  @XxlJob(value = "updateByConditionJobHandler")
  public ReturnT<String> updateByConditionJobHandler(String param) throws Exception {
    log.info("updateByConditionJobHandler begin......");
    try {
      UpdateAccountRequest accountRequest = new UpdateAccountRequest();
      accountRequest.setName("韩");
      accountRequest.setDeposit(1010f);
      accountService.updateByName(accountRequest);
    } catch (Exception e) {
      log.error("exception:{}", e);
    }
    log.info("updateByConditionJobHandler end......");
    return ReturnT.SUCCESS;
  }
}
