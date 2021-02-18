package com.jiangbo.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@Slf4j
@EnableFeignClients
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.jiangbo.user.gateway.acl.repositories")
public class UserApplication {

		public static void main(String[] args) {
				SpringApplication.run(UserApplication.class, args);
				log.info("启动成功...");
		}

}
