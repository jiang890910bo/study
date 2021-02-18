package com.jiangbo.user.gateway.ohs.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.jiangbo.user.domain.entity.OrderExtraInfo;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * UseController
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/06/14
 * @Version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/")
public class UseController {

  @Resource(name = "jackson")
  private RedisTemplate<Object, Object> jackRedisTemplate;

  @Resource(name = "fastJson")
  private RedisTemplate<Object, Object> fastRedisTemplate;

  @RequestMapping("/testJackson")
  public void testJackson(){
    long startTime = System.currentTimeMillis();
    OrderExtraInfo orderExtraInfo = (OrderExtraInfo) jackRedisTemplate.opsForValue().get("191300672896598017+2");
    long endTime = System.currentTimeMillis();
    log.info("Jackson解析花费时间：{}, 值：{}" , endTime - startTime , orderExtraInfo.toString());
  }

  @RequestMapping("/testFastJson")
  public void testFastJson(){
    long startTime = System.currentTimeMillis();
    OrderExtraInfo orderExtraInfo = (OrderExtraInfo) fastRedisTemplate.opsForValue().get("191300672896598017+2");
    long endTime = System.currentTimeMillis();
    log.info("FastJson解析花费时间：{}, 值：{}" , endTime - startTime , orderExtraInfo.toString());
  }

  @RequestMapping("/testJacksonStore")
  public void testJacksonStore(){
    OrderExtraInfo orderExtraInfo = (OrderExtraInfo) jackRedisTemplate.opsForValue().get("191300672896598017+2");
    fastRedisTemplate.opsForValue().set("jackson+191300672896598017", orderExtraInfo);
  }

  @RequestMapping("/testFastJsonStore")
  public void testFastJsonStore(){
    OrderExtraInfo orderExtraInfo = (OrderExtraInfo) fastRedisTemplate.opsForValue().get("191300672896598017+2");
    fastRedisTemplate.opsForValue().set("fastJson+191300672896598017", orderExtraInfo);
  }

  @RequestMapping("/serializationTest")
  public void serializationTest(){
    OrderExtraInfo orderExtraInfo = (OrderExtraInfo) jackRedisTemplate.opsForValue().get("191300672896598017+2");
    String fastJsonString = JSON.toJSONString(orderExtraInfo);
    log.info("fastJson解析长度：{}, 长度：{}" , fastJsonString, fastJsonString.length());
  }

  @GetMapping("/serializationTest")
  public String testListStreamForeach(){
    long start = System.currentTimeMillis();

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 300; i++) {
      list.add(i);
    }

    try {
      list.stream().forEach(var ->{
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }

    String msg = Thread.currentThread().getId() +  ", 单个循环耗时：" +  (System.currentTimeMillis() - start);
    System.out.println(msg);
    return msg;
  }

}
