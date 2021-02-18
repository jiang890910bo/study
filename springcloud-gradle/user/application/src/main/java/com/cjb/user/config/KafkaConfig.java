package com.cjb.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * KafkaConfig
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/08
 * @Version 1.0.0
 */
@Component
public class KafkaConfig {

  @Autowired
  private KafkaProperties properties;
  @Resource
  private KafkaTemplate<Object, Object> kafkaTemplate;

  @Bean
  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(this.properties.buildConsumerProperties()));
    // 代表某条消息发生3次错误后，放入死信队列，此处的3次，代表的不是重试3次，而是这条消息收到后处理报错，再重试2次，为3次。
    // 另外，请注意，放入死信队列的操作为纯客户端操作（其实就是把你收到的消息，再发到别的Topic去），网络不畅的情况下，可能失败！
    // 还有，死信队列的命名方式是在原有Topic名后追加 .DLT
    factory.setErrorHandler(new SeekToCurrentErrorHandler(new DeadLetterPublishingRecoverer(kafkaTemplate), 3));
    //设置消费者ack模式为手动
    //factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
    return factory;
  }

  @Bean(value = "currencyKafkaListenerContainerFactory")
  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> currencyKafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(this.properties.buildConsumerProperties()));
    // 代表某条消息发生3次错误后，放入死信队列，此处的3次，代表的不是重试3次，而是这条消息收到后处理报错，再重试2次，为3次。
    // 另外，请注意，放入死信队列的操作为纯客户端操作（其实就是把你收到的消息，再发到别的Topic去），网络不畅的情况下，可能失败！
    // 还有，死信队列的命名方式是在原有Topic名后追加 .DLT
    //factory.setErrorHandler(new SeekToCurrentErrorHandler(new DeadLetterPublishingRecoverer(kafkaTemplate), 3));
    //设置消费者ack模式为手动
   // factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
    factory.setConcurrency(Runtime.getRuntime().availableProcessors());
    factory.setBatchListener(Boolean.TRUE);
    return factory;
  }
}
