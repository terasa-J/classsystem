package com.eva.classsystem.utils;




import com.alibaba.fastjson.JSONObject;

import com.eva.classsystem.pojo.weChat.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


/**
 * 
<p>Title: WeiXinUtils</p>
<p>Describtion: 微信工具类</p>
 * @author Jiang Jiahong
 *@date 2017年11月16日 下午3:14:15
 */
public class WeiXinUtils {
	private final static String CHARSET = "UTF-8";
	
	private final static String APPID = "wx560c1b4a1b376300";
	
	private final static String APPSECRET = "85296372983b7d4f180126c83157d962";
	
	private final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	private final static String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	//GET 方法
	public static JSONObject doGetStr(String url){
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		HttpGet httpGet = new HttpGet( url );
		JSONObject jSONObject = null;
		try {
			HttpResponse httpResponse = httpClientBuilder.build().execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			if( null!=httpEntity ){
				String result = EntityUtils.toString(httpEntity,CHARSET );
				jSONObject = JSONObject.parseObject(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return jSONObject;
	}

	//POST 方法
	public static JSONObject doPostStr(String url , String str){
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(str, CHARSET));
		JSONObject jsonObject = null;
		try {
			HttpResponse httpResponse = httpClientBuilder.build().execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			if( null!=httpEntity ){
				String result = EntityUtils.toString(httpEntity,CHARSET );
				jsonObject = JSONObject.parseObject(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	//获取 token方法
	//注意： 获取的时候先找本地文件里存的token，如果时间超过7200秒就重新获取，这个方法可以避免多次刷新产生冲突
	public static AccessTokenPOJO getAccessToken(){
		AccessTokenPOJO accessTokenPOJO = new AccessTokenPOJO();
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonObject = null;
		try{
			jsonObject = doGetStr(url);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if( null != jsonObject ){
			accessTokenPOJO.setAccess_token(jsonObject.getString("access_token"));
			accessTokenPOJO.setExpires_in(jsonObject.getString("expires_in"));
		}
		return accessTokenPOJO;
	}
	

	//组装菜单
	public static MenuPOJO getMenu(){
		//ViewButton
		ViewButtonPOJO viewButtonPOJO = new ViewButtonPOJO();
		viewButtonPOJO.setName("进入课堂");
		viewButtonPOJO.setType("view");
		viewButtonPOJO.setUrl("http://www.baidu.com");
		
		//clickButton
		ClickButtonPOJO clickButton1 = new ClickButtonPOJO();
		clickButton1.setName("老师手册");
		clickButton1.setType("click");
		clickButton1.setKey("1");
		
		ClickButtonPOJO clickButton2 = new ClickButtonPOJO();
		clickButton2.setName("学生手册");
		clickButton2.setType("click");
		clickButton2.setKey("2");
		
		ButtonPOJO button = new ButtonPOJO();
		button.setName("帮助中心");
		button.setSub_button( new ButtonPOJO[]{clickButton1,clickButton2} );
		
		//拼接主菜单
		MenuPOJO menu = new MenuPOJO();
		menu.setButtonPOJO(new ButtonPOJO[]{viewButtonPOJO,button});
		
		return menu;
	}
	
	//创建菜单
	public static int createMenu(String token,String menu){
		int result = 0;
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, menu);
		if( jsonObject!=null ){
			result = jsonObject.getIntValue("errcode");
		}
		return result;
	}
}
