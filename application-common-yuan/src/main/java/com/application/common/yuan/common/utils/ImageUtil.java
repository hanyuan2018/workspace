package com.application.common.yuan.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageUtil {

	// 本地异常日志记录对象
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 	根据图片的url获取Base64形式的照片信息
	 * 
	 * @param url
	 * @return
	 */
	public String getBase64Image(String url) {
		String imageStr = "";
		try {
            URL urls = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");

            InputStream is=conn.getInputStream();
            byte[] buffer=new byte[1024];
			int len=0;
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			while((len=is.read(buffer))!=-1){
				bos.write(buffer,0,len);
			}
			byte[] data = bos.toByteArray();
			bos.flush();
			imageStr = Base64.encodeBase64String(data);
        } catch (Exception e) {
        	e.fillInStackTrace();
        	logger.error(e.getMessage());
        }
		return imageStr;
	}
}
