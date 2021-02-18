package com.jiangbo.user.application;

import com.jiangbo.user.config.AccountBaseConfig;
import com.jiangbo.user.config.ChengjiangboAccountBaseConfig;
import com.jiangbo.user.config.ChengjunhanAccountBaseConfig;
import com.jiangbo.user.config.HanmengxianAccountBaseConfig;
import com.jiangbo.user.enums.AccountEnum;
import com.jiangbo.user.gateway.ohs.vo.response.AccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AccountConfigService
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/08/15
 */
@Slf4j
@Component
@Order(1)
public class AccountConfigService implements ApplicationRunner {

  @Autowired
  private AccountService accountService;

  /**
   * 配置信息map
   * key：AccountEnum属性name
   * value: 明细配置对象AccountBaseConfig
   */
  private static ConcurrentHashMap<String, AccountBaseConfig> accountConfigMap = new ConcurrentHashMap<>(3);

  /**
   * 对外调用
   * @return
   */
  public static final AccountBaseConfig getAccountConfig(String name){
    AccountEnum accountEnum = AccountEnum.valueOf(name);
    return accountConfigMap.get(accountEnum);
  }

  @Override
  public void run(ApplicationArguments args) {
    log.info("启动预加载数据(ApplicationRunner)...{},{}", args.getSourceArgs(), args.getOptionNames());

//    AccountResponse cjbResponse = accountService.queryById(AccountEnum.CHENGJIANGBO.getId());
//    ChengjiangboAccountBaseConfig chengjiangboAccountBaseConfig = new ChengjiangboAccountBaseConfig();
//    BeanUtils.copyProperties(cjbResponse, chengjiangboAccountBaseConfig);
//    AccountResponse hmxResponse = accountService.queryById(AccountEnum.HANGMENGXIAN.getId());
//    HanmengxianAccountBaseConfig hanmengxianAccountBaseConfig = new HanmengxianAccountBaseConfig();
//    BeanUtils.copyProperties(hmxResponse, hanmengxianAccountBaseConfig);
//    AccountResponse cjhResponse = accountService.queryById(AccountEnum.CHENGJUNHAN.getId());
//    ChengjunhanAccountBaseConfig chengjunhanAccountBaseConfig = new ChengjunhanAccountBaseConfig();
//    BeanUtils.copyProperties(cjhResponse, chengjunhanAccountBaseConfig);
//
//    accountConfigMap.put(AccountEnum.CHENGJIANGBO.getName(), chengjiangboAccountBaseConfig);
//    accountConfigMap.put(AccountEnum.HANGMENGXIAN.getName(), hanmengxianAccountBaseConfig);
//    accountConfigMap.put(AccountEnum.CHENGJUNHAN.getName(), chengjunhanAccountBaseConfig);
  }
}
