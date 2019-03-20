package com.hzcominfo.application.custominterface.common.mongodb.abstraction;

import java.util.ArrayList;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import lombok.Data;

/**
 * mongodb对应的基础抽象类
 * 
 * 通过ip、端口、db名称、用户名与密码获取mongodb的连接
 * 
 * @author hanp
 *
 */
@Data
public abstract class AbstractMongoConfig {
	
	// mongodb对应的主机ip
	private String host;
	// mongodb对应的端口号
	private int port;
	// mongodb对应的db名称
	private String database;
	// mongodb对应的用户名
	private String username;
	// mmongodb对应的密码
	private String password;
    
    
    /**
     * 有认证的初始化方法
     * @return
     * @throws Exception
     */
	@SuppressWarnings("deprecation")
	public MongoDbFactory mongoDbFactory() throws Exception {
    	ServerAddress serverAddress = new ServerAddress(host, port);
    	ArrayList<MongoCredential> mongoCredentialList = new ArrayList<MongoCredential>();
    	mongoCredentialList.add(MongoCredential.createCredential(username, database, password.toCharArray()));
		return new SimpleMongoDbFactory(new MongoClient(serverAddress, mongoCredentialList), database);
    }
    
    /**
     * Factory  method to create the MongoTemplate
     * 
     */
    abstract public MongoTemplate getMongoTemplate() throws Exception;
}
