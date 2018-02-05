package com.eva.classsystem.pojo.weChatPojo;
/**
 * 接受微信端的文本消息
 * <xml>
 <ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[fromUser]]></FromUserName>
 <CreateTime>1348831860</CreateTime>
 <MsgType><![CDATA[text]]></MsgType>
 <Content><![CDATA[this is a test]]></Content>
 <MsgId>1234567890123456</MsgId>
 </xml>
 * @author Gargi
 *
 */

public class TextMessagePOJO extends BaseMessage{
	
	private String Content;
	
	private String MsgId;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	@Override
	public String toString() {
		return "TextMessagePOJO [Content=" + Content + ", MsgId=" + MsgId + "]";
	}

	
}
