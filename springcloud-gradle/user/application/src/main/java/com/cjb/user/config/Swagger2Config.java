package com.cjb.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2Config
 *
 * @Author chengjiangbo@shandiantech.com
 * @Date 2020/07/13
 * @Version 1.0.0
 */
@Component
public class Swagger2Config {

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      //是否开启 (true 开启  false隐藏。生产环境建议隐藏)
      .select()
      //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
      .apis(RequestHandlerSelectors.basePackage("com.cjb.user.controllers"))
      //指定路径处理PathSelectors.any()代表所有的路径
      .paths(PathSelectors.any())
      .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      //设置文档标题(API名称)
      .title("SpringBoot中使用Swagger2构建RESTful接口")
      //文档描述
      .description("接口说明")
      //服务条款URL
      .termsOfServiceUrl("http://127.0.0.1:8081/")
      //联系信息
      .contact("程江波")
      //版本号
      .version("1.0.0")
      .build();
  }
}
