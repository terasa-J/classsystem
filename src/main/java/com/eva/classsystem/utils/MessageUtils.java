
package com.eva.classsystem.utils;

import java.awt.Menu;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.eva.classsystem.pojo.weChat.NewsMessagePOJO;
import com.eva.classsystem.pojo.weChat.NewsPOJO;
import com.eva.classsystem.pojo.weChat.TextMessagePOJO;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;


/**
 * 接收 微信端的信息  ————> xml 转 message对象
 * 
 * 返回给微信端信息   ————> message 转 xml 对象
 * * <xml>
 <ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[fromUser]]></FromUserName>
 <CreateTime>1348831860</CreateTime>
 <MsgType><![CDATA[text]]></MsgType>
 <Content><![CDATA[this is a test]]></Content>
 <MsgId>1234567890123456</MsgId>
 </xml>
 * @author Gargi
 * @date 2017-11-15
 */
public class MessageUtils {
	//消息类型如下
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_NEWS = "news";
	
	
	// * 接收 微信端的信息  ————> xml 转 message对象
	
	public static Map xmlToTextMessage( HttpServletRequest request ){
		Map< String,String > testMessageMap = new HashMap< String,String >();
		SAXReader saxReader = new SAXReader();
		InputStream intputStream = null ;
		try {
			intputStream = request.getInputStream();
			Document document = saxReader.read( intputStream );
			Element root = document.getRootElement();
			List< Element > listElement = root.elements();
			for( Element element : listElement ){
				testMessageMap.put( element.getName(), element.getText() );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {
				intputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return testMessageMap;
	}
	
	//返回给微信端信息   ————> message 转 xml 对象
	
	public static String textMessageToXml( TextMessagePOJO textMessagePOJO ){
		XStream xstream = new XStream();
		//设置生成的xml文档的根元素 为xml
		xstream.alias( "xml", TextMessagePOJO.class );
		String message = xstream.toXML( textMessagePOJO );
		return message;
	}

	//初始化回复的信息 都是text类型  拼接文本消息
	public static String intiText(String toUserName,String fromUserName,String content){
		TextMessagePOJO message = new TextMessagePOJO();
		message.setContent( content );
		message.setCreateTime( new Date().getTime()+"" );
		message.setFromUserName( toUserName );
		message.setToUserName( fromUserName );
		message.setMsgType( MessageUtils.MESSAGE_TEXT );
		return MessageUtils.textMessageToXml(message);
	}
	
	public static String firstMenu(){
		StringBuffer str = new StringBuffer();
		str.append("本套课程介绍微信公众号开发，主要涉及公众号介绍、编辑模式介绍、开发模式介绍等。");
		return str.toString();
	}
	
	public static String secondMenu(){
		StringBuffer str = new StringBuffer();
		str.append("慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、"
                + "问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公"
                + "开视频课程学习国内领先的互联网IT技术。");
		return str.toString();
	}
	//主菜单
	public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎您的关注，请按照菜单提升进行操作：\n\n");
        sb.append("1、课程介绍\n");
        sb.append("2、慕课网介绍\n\n");
        sb.append("回复？调出此菜单。");
        return sb.toString();
    }
	
	//图文消息转换为XML
	public static String newsMessageToXml( NewsMessagePOJO newsMessagePOJO ){
		XStream xstream = new XStream();
		//设置生成的xml文档的根元素 为xml
		xstream.alias( "xml", NewsMessagePOJO.class );
		xstream.alias( "item", NewsPOJO.class );
		String message = xstream.toXML( newsMessagePOJO );
		return message;
	}
	
	//初始化图文消息
	 /**<xml>
	 <ToUserName><![CDATA[toUser]]></ToUserName>
	 <FromUserName><![CDATA[fromUser]]></FromUserName>
	 <CreateTime>12345678</CreateTime>
	 <MsgType><![CDATA[news]]></MsgType>
	 <ArticleCount>2</ArticleCount>
	 <Articles>

	 <item>
	 <Title><![CDATA[title1]]></Title> 
	 <Description><![CDATA[description1]]></Description>
	 <PicUrl><![CDATA[picurl]]></PicUrl>
	 <Url><![CDATA[url]]></Url>
	 </item>

	 </Articles>
	 </xml>*/
	public static String initNewsMessage(String toUserName,String fromUserName){
		NewsMessagePOJO newsMessagePOJO = new NewsMessagePOJO();
		List<NewsPOJO> listNews = new ArrayList<NewsPOJO>();
		
		//第一个图文消息
		NewsPOJO newsPOJO = new NewsPOJO();
		newsPOJO.setTitle("first");
		newsPOJO.setDescription("第一个图文消息");
		newsPOJO.setPicUrl("http://miffy.free.ngrok.cc/weChat/image/01.jpg");
		newsPOJO.setUrl("www.baidu.com");
		//第二个图文消息
		NewsPOJO newsPOJOSecond = new NewsPOJO();
		newsPOJOSecond.setTitle("Second");
		newsPOJOSecond.setDescription("第二个图文消息");
		newsPOJOSecond.setPicUrl("http://miffy.free.ngrok.cc/weChat/image/02.jpg");
		newsPOJOSecond.setUrl("www.baidu.com");
		
		//添加到list中
		listNews.add(newsPOJO);
		listNews.add(newsPOJOSecond);
		
		newsMessagePOJO.setToUserName(fromUserName);
		newsMessagePOJO.setFromUserName(toUserName);
		newsMessagePOJO.setCreateTime(new Date().getTime() + "");
		newsMessagePOJO.setMsgType(MessageUtils.MESSAGE_NEWS);
		newsMessagePOJO.setArticles(listNews);
		newsMessagePOJO.setArticleCount(listNews.size());
		
		//封装成xml
		String result = MessageUtils.newsMessageToXml(newsMessagePOJO);
		return result;
	}
	
}
