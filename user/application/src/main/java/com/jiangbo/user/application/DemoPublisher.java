package com.jiangbo.user.application;

import com.jiangbo.user.application.event.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * DemoPublisher
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/11/04
 */
@Component
public class DemoPublisher {

  @Autowired
  private ApplicationContext applicationContext;

  public void publish(String msg){
    applicationContext.publishEvent(new DemoEvent(applicationContext, msg));
  }
}
