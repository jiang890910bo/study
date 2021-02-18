package com.jiangbo.user.gateway.ohs.controller;

import com.jiangbo.user.application.ProxyAccessService;
import com.jiangbo.user.domain.service.ProxyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * ProxyControllerTest
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/06/20
 * @Version 1.0.0
 */
@RestController
public class ProxyTestController {

  @Autowired
  private ProxyAccessService proxyAccessService;

  @RequestMapping("/index.html")
  public String index(@RequestParam(value = "channel")String channel) throws IOException {
    return proxyAccessService.index(channel);
  }

}
