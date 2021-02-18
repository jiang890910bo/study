package com.jiangbo.user.gateway.acl.client;

import feign.Contract;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * BrowserServiceClient
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/07/26
 */
@FeignClient(value = "baidu", configuration = BrowserServiceClient.FeignClientConfiguration.class, fallbackFactory = BrowserServiceClientFallBackFactory.class)
public interface BrowserServiceClient {

  /**
   * 首页
   * @return
   */
  @RequestLine("GET /{index}")
  String index(@Param("index")String index);

  class FeignClientConfiguration{
    @Bean
    public Contract feignContract() {
      return new feign.Contract.Default();
    }
  }
}
