package com.jiangbo.user.gateway.ohs.controller;

import com.jiangbo.user.application.DemoPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApplicatonEventController
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/11/04
 */
@RestController
public class ApplicatonEventController {

  @Autowired
  private DemoPublisher demoPublisher;

  @GetMapping(value = "/testMsg")
  public void testMsg(@RequestParam String msg){
    demoPublisher.publish(msg);
  }
}
