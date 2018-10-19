package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * User: Phil. Date: 2018/7/19 Time: 16:14 Created by IntelliJ IDEA.
 */
public class HttpUtils1 {

	@Test
	public void testGet() throws IOException {
		List<NameValuePair> nvps = new ArrayList<>();
		nvps.add(new BasicNameValuePair("productIds", "444444444444"));
		nvps.add(new BasicNameValuePair("productIds", "24"));
		HttpUtils.MyHttpResponse myHttpResponse = HttpUtils.doGet("http://192.168.1.153:8091/design/banners/", null, nvps);
		System.out.println(myHttpResponse.getCode());
		System.out.println(myHttpResponse.getBody());
	}

	@Test
	public void testPost() throws IOException {
		List<NameValuePair> nvps = new ArrayList<>();
		nvps.add(new BasicNameValuePair("productIds", "444444444444"));
		nvps.add(new BasicNameValuePair("productIds", "24"));
		HttpUtils.MyHttpResponse myHttpResponse = HttpUtils.doPost("http://127.0.0.1:8091/design/dictionary/productIds", null, nvps);
		System.out.println(myHttpResponse.getCode());
		System.out.println(myHttpResponse.getBody());
		JSONObject jsonObject = JSON.parseObject(myHttpResponse.getBody());
		System.out.println(jsonObject);
	}

	@Test
    public void t(){
        System.out.println(HttpUtils.sendGet("http://127.0.0.1:8091/design/dictionary/productIds",null));
    }
}
