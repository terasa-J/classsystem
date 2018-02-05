package com.eva.classsystem.pojo.weChatPojo;
/**
 * 
<p>Title: 关注/取消关注事件</p>
<p>Describtion: 关注/取消关注事件的XML元素
<xml>
<ToUserName><![CDATA[toUser]]></ToUserName>
<FromUserName><![CDATA[FromUser]]></FromUserName>
<CreateTime>123456789</CreateTime>
<MsgType><![CDATA[event]]></MsgType>
<Event><![CDATA[subscribe]]></Event>
</xml>
</p>
 * @author Gargi
 *@date 2017年11月15日 下午4:47:22
 */
public class EventMessagePOJO extends BaseMessage{

	private String Event;
	
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	@Override
	public String toString() {
		return "EventMessagePOJO [Event=" + Event + "]";
	}

	

}
