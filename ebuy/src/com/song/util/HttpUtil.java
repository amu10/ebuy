package com.song.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	
	private static HttpClient  httpClient = new DefaultHttpClient();
	
	private static final String BASE_URL ="http://10.0.2.2/ebuy/";
	
	 public static String getRequest(String url)
	 {
		 HttpGet  get = new HttpGet();
		 try {
			HttpResponse response = httpClient.execute(get);
			if(response.getStatusLine().getStatusCode()==200)
			{
				String result = EntityUtils.toString(response.getEntity());
				return result;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	 }
	 
	public static String postRequest(String url, Map<String,String> rawParams)
	{
		HttpPost post = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for(String key :rawParams.keySet())
		{
			params.add(new BasicNameValuePair(key, rawParams.get(key)));
		}
		try {
			post.setEntity(new UrlEncodedFormEntity(params,"gbk"));
			HttpResponse response =  httpClient.execute(post);
			if(response.getStatusLine().getStatusCode()==200)
			{
				String result = EntityUtils.toString(response.getEntity());
				return result;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
