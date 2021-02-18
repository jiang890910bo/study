package com.jiangbo.user.application.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * DemoListener
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/11/04
 */
@Slf4j
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

  @Override
  public void onApplicationEvent(DemoEvent demoEvent) {
    if(demoEvent instanceof DemoEvent){
      log.info("接收到消息：" + demoEvent.getMsg());
    }
  }
}
