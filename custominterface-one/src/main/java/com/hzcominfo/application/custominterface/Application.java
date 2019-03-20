package com.hzcominfo.application.custominterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import com.hzcominfo.application.custominterface.common.mongodb.annotation.EnableMongoPlus;

@EnableMongoPlus	// 该注解用于初始化mongodb连接的配置信息
@SpringBootApplication
@EnableAutoConfiguration(exclude= { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
