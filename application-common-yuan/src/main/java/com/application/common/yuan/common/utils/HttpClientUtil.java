package com.application.common.yuan.common.utils;

import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class HttpClientUtil {

	// 本地异常日志记录对象
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 /**
     * 执行post方法
     * @param url
     * @param params
     * @return
     */
    public  String postMethod(String url, Map<String, Object> params){
        JSONObject jsonObj = new JSONObject();
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(url);
            
            int count = 0;
            NameValuePair[] nameValuePairs = new NameValuePair[params.size()];
            for(String key : params.keySet()){
                String value = params.get(key) == null ? "" : params.get(key).toString();
                NameValuePair param = new NameValuePair(key, value);
                nameValuePairs[count] = param;
                count ++ ;
            }
            post.setRequestBody(nameValuePairs);
            client.executeMethod(post);
            String respStr = post.getResponseBodyAsString();
            post.releaseConnection();
            return respStr;
        } catch (Exception e) {
            e.fillInStackTrace();
            logger.error(e.getMessage());
            jsonObj.put("code", "1");
            jsonObj.put("msg", e.getMessage());
            return jsonObj.toString();
        }
        
    }
	
}
