package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(value="com.demo.mapper")
@EnableCaching
@EnableAsync  //开启异步任务
@EnableScheduling //开启定时任务功能
//public class SpringbootMybaitsRedisApplication extends SpringBootServletInitializer {
public class SpringbootMybaitsRedisApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootMybaitsRedisApplication.class, args);
	}
}
