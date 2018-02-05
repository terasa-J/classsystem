package com.eva.classsystem.pojo.weChatPojo;
/**
 * 
<p>Title: AccessToken</p>
<p>Describtion: AccessToken</p>
 * @author Jiang Jiahong
 *@date 2017年11月16日 下午3:33:09
 */
public class AccessTokenPOJO {
	private String access_token;
	private String expires_in;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	@Override
	public String toString() {
		return "AccessTokenPOJO [access_token=" + access_token + ", expires_in=" + expires_in + "]";
	}
	
}
