package com.jiangbo.user.protoBuffTest;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * CommonConfig
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2021/03/11
 */
public class CommonConfig {

	/**
	 * protobuf 序列化
	 */
	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

	/**
	 * protobuf 反序列化
	 */
	@Bean
	RestTemplate restTemplate(ProtobufHttpMessageConverter protobufHttpMessageConverter) {
		return new RestTemplate(Collections.singletonList(protobufHttpMessageConverter));
	}
}
