package com.jiangbo.user.config;

import com.jiangbo.user.utils.UserEnvUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * UserProxySelector
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/06/20
 * @Version 1.0.0
 */
@Slf4j
public class UserProxySelector extends ProxySelector {

  //百度
  private final String IP = "115.29.223.128";
  //谷歌
  //private final String IP = "203.208.41.34";
  //本机swagger
  private final int PORT = 80;

  @Override
  public List<Proxy> select(URI uri) {
    Proxy proxy = Proxy.NO_PROXY;
    log.info("UserEnvUtils.getEnvironment():{}", UserEnvUtils.getEnvironment());
    String proxyUrls = UserEnvUtils.getEnvironment().getProperty("baidu.need.proxy.urls");
    log.info("proxyUrls:{}", proxyUrls);

    if(StringUtils.isNotBlank(proxyUrls)){
      String[] urls =  proxyUrls.split(",");
      for (String url : urls) {
        log.info("uri:{}, url:{}", uri, url);
        if(uri.toString().contains(url)){
          proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(IP, PORT));
          break;
        }
      }
    }
    log.info("url [{}]，使用的代理信息 [{}]", uri, proxy);
    return Collections.singletonList(proxy);
  }

  @Override
  public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
    log.error("代理服务链接失败， host:{}, port:{}", IP, PORT);
  }

}
