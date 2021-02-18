package com.jiangbo.user.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * RedisConfig
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/06/13
 * @Version 1.0.0
 */
@Configuration
public class RedisConfig {

  @Bean("jackson")
  public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
    //指定Jackson2JsonRedisSerializer为Object的序列化器，替代redis默认的序列化器JdkSerializationRedisSerializer
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);

    ObjectMapper objectMapper = new ObjectMapper();
    //反序列化时智能识别变量名（识别没有按驼峰格式命名的变量名）
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    //反序列化识别对象类型
    objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    //反序列化如果有多的属性，不抛出异常
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //反序列化如果碰到不识别的枚举值，是否作为空值解释，true:不会抛不识别的异常, 会赋空值，false:会抛不识别的异常
    objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);

    jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.afterPropertiesSet();

    return redisTemplate;
  }


  @Bean("fastJson")
  public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory, RedisSerializer fastJson2JsonRedisSerializer) {
    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);

    //key采用String序列化方式
    StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    redisTemplate.setKeySerializer(stringRedisSerializer);
    redisTemplate.setHashKeySerializer(stringRedisSerializer);

    //value采用fast-json序列化方式。
    redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer);
    redisTemplate.setHashValueSerializer(fastJson2JsonRedisSerializer);

    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

  @Bean
  public RedisSerializer fastJson2JsonRedisSerializer() {
    return new FastJson2JsonRedisSerializer<>(Object.class);
  }

  public static class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private Class<T> clazz;

    public FastJson2JsonRedisSerializer(Class<T> clazz) {
      super();
      this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
      if (t == null) {
        return new byte[0];
      }
      return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
      if (bytes == null || bytes.length <= 0) {
        return null;
      }
      String str = new String(bytes, DEFAULT_CHARSET);
      return JSON.parseObject(str, clazz, Feature.SupportAutoType);
    }

  }


  /**
   * protobuf 序列化
   */
  @Bean
  public ProtobufHttpMessageConverter protobufHttpMessageConverter() {
    return new ProtobufHttpMessageConverter();
  }

  /**
   * protobuf 反序列化
   */
  @Bean(name="protobuf")
  public RestTemplate restTemplate(ProtobufHttpMessageConverter protobufHttpMessageConverter) {
    return new RestTemplate(Collections.singletonList(protobufHttpMessageConverter));
  }
}
