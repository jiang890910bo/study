package com.jiangbo.user.gateway.acl.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * BrowserServiceClientFallBackFactory
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/12/13
 */
@Slf4j
@Component
public class BrowserServiceClientFallBackFactory implements FallbackFactory<BrowserServiceClient> {
  @Override
  public BrowserServiceClient create(Throwable cause) {
    log.error("exception:", cause);
    return (String index) -> "请求失败";
  }
}
