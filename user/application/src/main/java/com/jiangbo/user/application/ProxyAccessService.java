package com.jiangbo.user.application;

import com.jiangbo.user.domain.service.ProxyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProxyAccessService
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/07/26
 */
@Service
public class ProxyAccessService {
  @Autowired
  private ProxyTestService proxyTestService;

  public String index(String channel){
    return proxyTestService.index(channel);
  }
}
