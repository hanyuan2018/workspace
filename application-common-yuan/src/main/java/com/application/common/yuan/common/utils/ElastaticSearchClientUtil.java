package com.application.common.yuan.common.utils;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 * ElastaticSearch 连接工具类
 * 
 * @author hanp
 *
 */
public class ElastaticSearchClientUtil {

	public static TransportClient client;

	public ElastaticSearchClientUtil() {
	}

	/**
	 * 取得实例参数
	 * 
	 * @return
	 */
	public synchronized TransportClient getTransportClient() {
		return client;
	}

	/**
	 * TransportClient客户端连接方式
	 * 
	 * @param esIp
	 * @param esPort
	 * @param clusterName
	 * @throws Exception
	 */
	public ElastaticSearchClientUtil(String esIp, int esPort, String clusterName) throws Exception {
		// 启用嗅探，设置client.transport.sniff为true:
		Settings settings = Settings.builder()
				.put("cluster.name", clusterName)
				.put("client.transport.sniff", true)
				.build();
		client = new PreBuiltTransportClient(settings);
		client.addTransportAddress(new TransportAddress(InetAddress.getByName(esIp), esPort));
	}

}
