package com.eva.classsystem.pojo.weChatPojo;
/**
 * 
<p>Title: BaseMessage</p>
<p>Describtion: 所有消息类型都需要的字段</p>
 * @author Gargi
 *@date 2017年11月16日 下午12:39:14
 */
public class BaseMessage {
	private String ToUserName;
	
	private String FromUserName;
	
	private String CreateTime;
	
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	@Override
	public String toString() {
		return "BaseMessage [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime
				+ ", MsgType=" + MsgType + "]";
	}
}
