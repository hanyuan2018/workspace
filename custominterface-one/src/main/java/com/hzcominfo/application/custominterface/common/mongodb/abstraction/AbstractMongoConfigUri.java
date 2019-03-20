package com.hzcominfo.application.custominterface.common.mongodb.abstraction;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClientURI;

import lombok.Data;

/**
 * mongodb对应的基础抽象类
 * 
 * 通过mongodb的链接字符串获取连接
 * 
 * @author hanp
 *
 */
@Data
public abstract class AbstractMongoConfigUri {
	
	// mongodb的链接字符串
	private String uri;
	
	/*
     * Method that creates MongoDbFactory Common to both of the MongoDb
     * connections
     */
    public MongoDbFactory mongoDbFactory() throws Exception {

        return new SimpleMongoDbFactory(new MongoClientURI(uri));
    }

    /*
     * Factory method to create the MongoTemplate
     */
    abstract public MongoTemplate getMongoTemplate() throws Exception;
	
}

