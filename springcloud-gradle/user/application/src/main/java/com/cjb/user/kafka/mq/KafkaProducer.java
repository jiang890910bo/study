package com.cjb.user.kafka.mq;

import com.alibaba.fastjson.JSONObject;
import com.cjb.user.message.OrderStatusMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

/**
 * KafkaProducer
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/13
 * @Version 1.0.0
 */
@Slf4j
@Component
public class KafkaProducer {

  @Resource
  private KafkaTemplate<String, String> kafkaTemplate;

  @Value("${kafka.topics.order-send}")
  private String topic;

  /**
   * 发送mq消息
   */
  public void sendMq(OrderStatusMessage orderStatusMessage){
    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, JSONObject.toJSONString(orderStatusMessage));
//    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//      @Override
//      public void onFailure(Throwable ex) {
//        log.error(" topic:{} 发送失败 exception:{}，, value:{} ", ex.getMessage(), topic,  JSONObject.toJSONString(orderStatusMessage));
//      }
//
//      @Override
//      public void onSuccess(SendResult<String, String> result) {
//        log.info("topic:{} 发送成功 result:{}" , topic, result);
//      }
//    });
  }
}
