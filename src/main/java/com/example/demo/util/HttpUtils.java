package com.example.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * User: Phil. Date: 2018/1/17 Time: 18:59 Created by IntelliJ IDEA.
 */
public class HttpUtils {
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.setRequestProperty("Cookie", "SESSION=e6de027b-0843-463d-a5bd-e8797c6fd4dc");
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));//防止乱码
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public static MyHttpResponse doGet(String uri,Header[] headers,List<NameValuePair> pairs) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            if (pairs != null && !pairs.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (NameValuePair pair : pairs) {
                    stringBuilder.append(pair.getName()).append("=").append(pair.getValue()).append("&");

                }
                uri = uri + "?" + stringBuilder.toString().substring(0,stringBuilder.length()-2);
            }

            HttpGet httpget = new HttpGet(uri);
            if (headers != null && headers.length > 0) {
                httpget.setHeaders(headers);
            }
            MyResponseHandler responseHandler = new MyResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            JSONObject jb = JSON.parseObject(responseBody);
            System.out.println(jb.get("code"));
            System.out.println(jb.getJSONArray("body").get(0));
            return JSON.parseObject(responseBody, MyHttpResponse.class);
        }
	}

	public static MyHttpResponse doPost(String uri,Header[] headers,List<NameValuePair> pairs) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(uri);
            if (headers != null && headers.length > 0) {
                httpPost.setHeaders(headers);
            }
            if (pairs != null && !pairs.isEmpty()) {
                List<NameValuePair> nameValuePairs = new ArrayList<>();
                nameValuePairs.addAll(pairs);
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            }
            MyResponseHandler responseHandler = new MyResponseHandler();
            String responseBody = httpclient.execute(httpPost, responseHandler);
            return JSON.parseObject(responseBody, MyHttpResponse.class);
        }
	}

	public static void main(String[] args) throws IOException {
		List<NameValuePair> nvps = new ArrayList<>();
		nvps.add(new BasicNameValuePair("productIds", "444444444444"));
		nvps.add(new BasicNameValuePair("productIds", "24"));
        MyHttpResponse myHttpResponse = doGet("http://192.168.1.153:8091/design/banners/", null, nvps);
        System.out.println(myHttpResponse.getCode());
        System.out.println(myHttpResponse.getBody());

		//        List<NameValuePair> nvps = new ArrayList<>();
		//        nvps.add(new BasicNameValuePair("productIds", "444444444444"));
		//        nvps.add(new BasicNameValuePair("productIds", "24"));
		//		doPost("http://127.0.0.1:8091/design/dictionary/productIds",null,nvps);
	}

	static class MyResponseHandler extends BasicResponseHandler{
        @Override
        public String handleResponse(final HttpResponse response) throws IOException {
            HttpEntity entity = response.getEntity();
            String body = entity != null ? EntityUtils.toString(entity) : null;
            System.out.println("body:");
            System.out.println(body);
            int code = response.getStatusLine().getStatusCode();
            MyHttpResponse myHttpResponse = new MyHttpResponse(code, body);
            return JSON.toJSONString(myHttpResponse);
        }
    }

    @Data
    @AllArgsConstructor
    public static class MyHttpResponse{
        private int code;
        private String body;
    }

}
