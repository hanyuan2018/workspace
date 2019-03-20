package com.hzcominfo.application.custominterface.common.mongodb.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.hzcominfo.application.custominterface.common.mongodb.abstraction.AbstractMongoConfigUri;

/**
 * 获取车辆照片时使用
 * @author hanp
 * 
 * prefix需要与配置文件中车辆照片vehicle数据源的配置前缀对应
 *
 */
@Configuration  
@ConfigurationProperties(prefix = "spring.data.mongodb.vehicle")
public class VehiclePictureMongoConfigUri extends AbstractMongoConfigUri{

    @Bean(name = "vehicleMongoTemplate")
	public MongoTemplate getMongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

}
