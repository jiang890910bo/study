package com.jiangbo.user.gateway.ohs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SwaggerConfig
 *
 * @Author chengjianbo@shandiantech.com
 * @Date 2020/05/09
 * @Version 1.0.0
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket userApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.jiangbo.user.gateway.ohs.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("user服务端提供者接口平台").description("user服务端接口")
                .license("Licence Version 1.0").version("1.0").build();
    }
}
