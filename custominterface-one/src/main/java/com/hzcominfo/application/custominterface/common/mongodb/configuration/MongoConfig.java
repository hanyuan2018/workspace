package com.hzcominfo.application.custominterface.common.mongodb.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.hzcominfo.application.custominterface.common.mongodb.abstraction.AbstractMongoConfig;

/**
 * 通过ip、port、database、usernam与password获取mongodb连接
 * 
 * @author hanp
 * 
 * prefix需要与配置文件中mongodb数据源的配置前缀对应
 *
 */
@Configuration  
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoConfig extends AbstractMongoConfig{

    @Bean(name = "mongoTemplate")
	public MongoTemplate getMongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

}
