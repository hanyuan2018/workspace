package com.application.common.yuan.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.application.common.yuan.common.constants.AttrConstants;
import com.github.pagehelper.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * ElastaticSearch sql语句查询工具类
 * 
 * @author hanp
 *
 */
public class ElastaticSearchSqlUtil {

	/**
     * 执行post方法, 查询ES数据
     * 
     * @param url
     * @param params
     * @return
     */
    public static JSONObject doPostDataMethod(String url, String sql) {
        JSONObject jsonObj = new JSONObject();
        try {
            // 拼接查询条件
            String query = "{\n\"query\":\"" + sql + "\"\n}";
            // 使用OkHttpClient请求方式
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, query);
            Request request = new Request.Builder().url(url).post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache").build();
            Response response = client.newCall(request).execute();
            String content = response.body().string();
            List<Map<String, Object>> esResult = getEsDataResult(content);
            jsonObj.put("errcode", "0");
            jsonObj.put("errmsg", AttrConstants.SUCCESS);
            jsonObj.put("result", esResult);
        } catch (Exception e1) {
            e1.printStackTrace();
            jsonObj.put("errcode", "1");
            jsonObj.put("errmsg", "post方法，远程调用时出错！");
        }
        return jsonObj;
    }
    
    /**
     * 执行post方法, 查询ES，返回list集合数据
     * 
     * @param url
     * @param params
     * @return
     * @throws Exception 
     */
    public static List<Map<String, Object>> doPostData(String url, String sql) throws Exception {
            // 拼接查询条件
            String query = "{\n\"query\":\"" + sql + "\"\n}";
            // 使用OkHttpClient请求方式
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, query);
            Request request = new Request.Builder().url(url).post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache").build();
            Response response = client.newCall(request).execute();
            String content = response.body().string();
            List<Map<String, Object>> esResult = getEsDataResult(content);

        return esResult;
    }

    public static Map<String, Object> doPostMethod(String url, String sql) throws Exception {
        // 拼接查询条件
        String query = "{\n\"query\":\"" + sql + "\"\n}";
        // 使用OkHttpClient请求方式
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, query);
        Request request = new Request.Builder().url(url).post(body)
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache").build();
        Response response = client.newCall(request).execute();
        String content = response.body().string();
        // 将结果转换成Map
        Map<String, Object> countResult = getEsCountResult(content);
        return countResult;
    }
    
    /**
     * 将查询到ES的数据封装到List<Map<String, Object>>中
     * 
     * @param esData
     * @return
     */
    public static List<Map<String, Object>> getEsDataResult(String esData) {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        JSONObject json = JSONObject.fromObject(esData);
        // 字段
        String columns = json.get("columns") != null ? json.get("columns").toString() : "";
        // 字段值
        String rows = json.get("rows") != null ? json.get("rows").toString() : "";
        if (StringUtil.isNotEmpty(columns) && StringUtil.isNotEmpty(rows)) {
            JSONArray columnsArr = JSONArray.fromObject(columns);
            JSONArray rowsArr = JSONArray.fromObject(rows);
            for (Object object : rowsArr) {
                JSONArray signalArr = JSONArray.fromObject(object);
                Map<String, Object> eachData = getEachData(signalArr, columnsArr);
                resultList.add(eachData);
            }
        } else {
            System.out.println("ES查询报错信息：" + json.get("error"));
        }
        return resultList;
    }

    /**
     * 将查询到ES的数据统计数量封装到Map<String, Object>中
     * 
     * @param esData
     * @return
     */
    public static Map<String, Object> getEsCountResult(String esData) {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        JSONObject json = JSONObject.fromObject(esData);
        // 字段
        String columns = json.get("columns") != null ? json.get("columns").toString() : "";
        // 字段值
        String rows = json.get("rows") != null ? json.get("rows").toString() : "";
        if (StringUtil.isNotEmpty(columns) && StringUtil.isNotEmpty(rows)) {
            JSONArray columnsArr = JSONArray.fromObject(columns);
            JSONArray rowsArr = JSONArray.fromObject(rows.replaceAll("\"", ""));
            for (Object object : rowsArr) {
                JSONArray signalArr = JSONArray.fromObject(object);
                Map<String, Object> eachData = getEachData(signalArr, columnsArr);
                resultList.add(eachData);
            }
            return resultList.get(0);
        } else {
            System.out.println("ES查询报错信息：" + json.get("error"));
            return new HashMap<String, Object>();
        }
    }

    /**
     * 将查询ES的每条数据以key-value的形式封装到map中
     * 
     * @param signalArr
     * @param columnsArr
     * @return
     */
    public static Map<String, Object> getEachData(JSONArray signalArr, JSONArray columnsArr) {
        Map<String, Object> map = new HashMap<String, Object>();
        int num = 0;
        for (Object object : signalArr) {
            JSONObject jsonObj = JSONObject.fromObject(columnsArr.get(num));
            if(null == object || "null".equals(object)) {
                object = "";
            }
            map.put(jsonObj.get("name").toString(), object);
            num++;
        }
        return map;
    }
}
