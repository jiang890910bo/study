package com.jiangbo.user.application.event;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * DemoEvent
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/11/04
 */
@Getter
@Setter
public class DemoEvent extends ApplicationEvent {

  private String msg;


  public DemoEvent(Object source, String msg) {
    super(source);
    this.msg = msg;
  }
}
