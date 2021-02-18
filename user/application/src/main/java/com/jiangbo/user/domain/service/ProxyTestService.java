package com.jiangbo.user.domain.service;

import com.jiangbo.user.gateway.acl.client.BrowserServiceClient;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ProxyTestService
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/07/26
 */
@Component
public class ProxyTestService {

  @Resource
  private BrowserServiceClient browserServiceClient;

  @Value("${baidu.url}")
  private String baiduUrl;

  @Value("${sougou.url}")
  private String sougouUrl;

  /**
   * 访问首页
   * @param channel
   * @return
   */
  public String index(String channel){
    String  url = baiduUrl;
    if("sougou".equalsIgnoreCase(channel)){
      url = sougouUrl;
    }
    browserServiceClient = Feign.builder().target(BrowserServiceClient.class, url);
    return browserServiceClient.index("index.html");
  }
}
