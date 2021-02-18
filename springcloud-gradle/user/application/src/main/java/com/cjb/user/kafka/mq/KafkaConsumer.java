package com.cjb.user.kafka.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cjb.user.message.OrderStatusMessage;
import com.cjb.user.message.OrderStatusMessage1;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * KafkaConsumer
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/13
 * @Version 1.0.0
 */
@Slf4j
@Component
public class KafkaConsumer {

  @Value("#{'${kafka.topics.order-send}'.split(',')}")
  private String topic;

  /**
   * 手动确认消息消费
   *
   * @param record 消息记录
   */
//  @KafkaListener(topics = "${kafka.topics.order-send}", groupId = "${spring.kafka.user.group-id}", containerFactory = "currencyKafkaListenerContainerFactory")
//  public void event(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
//    OrderStatusMessage orderStatusMessage = null;
//    log.info("消息消费：{}， factory:{}", record);
//    orderStatusMessage = JSON.parseObject(record.value(), OrderStatusMessage.class);
//    //int num = 1 / 0;
//    log.info("消息内容解析结果：[{}]", JSONObject.toJSONString(orderStatusMessage));
//    acknowledgment.acknowledge();
//  }

  /**
   * 手动确认消息消费
   *
   * @param record 消息记录
   */
  @KafkaListener(topics = "${kafka.topics.order-send}", groupId = "${spring.kafka.user.group-id}")
  public void event1(List<OrderStatusMessage1> list/*, Acknowledgment acknowledgment*/) {
    list.forEach(msg ->{
      log.info("消息消费1：{}", msg);
    });
//    OrderStatusMessage1 orderStatusMessage = null;
//    log.info("消息消费1：{}， factory:{}", record);
////    if(1==1){
////      return;
////    }
//    orderStatusMessage = JSON.parseObject(record.value(), OrderStatusMessage1.class);
//    //int num = 1 / 0;
//    log.info("消息内容解析结果：[{}]", JSONObject.toJSONString(orderStatusMessage));
    //acknowledgment.acknowledge();
  }




  //死信队列
  //@KafkaListener(topics = "${kafka.topics.order-send}" + ".DLT", groupId = "${spring.kafka.user.group-id}")
//  public void dltListen(String input) {
//    log.info("Received from DLT: " + input);
//  }
}
