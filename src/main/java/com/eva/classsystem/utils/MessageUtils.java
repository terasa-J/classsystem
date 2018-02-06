package com.eva.classsystem.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.eva.classsystem.pojo.weChatPojo.TextMessagePOJO;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;


/**
 * 接收 微信端的信息  ————> xml 转 message对象
 * <p>
 * 返回给微信端信息   ————> message 转 xml 对象
 * * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>1348831860</CreateTime>
 * <MsgType><![CDATA[text]]></MsgType>
 * <Content><![CDATA[this is a test]]></Content>
 * <MsgId>1234567890123456</MsgId>
 * </xml>
 *
 * @author Jiang Jiahong
 * @date 2017-11-15
 */
public class MessageUtils {
    //需要的消息类型如下
    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    

    /**
     * @Author: Jiang Jiahong
     * @Description: xml 转 message对象
     * @Date: 2018/2/5 16:06
     */
    public static Map xmlToTextMessage(HttpServletRequest request) {
        Map<String, String> testMessageMap = new HashMap<String, String>();
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            Document document = saxReader.read(inputStream);
            Element root = document.getRootElement();
            List<Element> listElement = root.elements();
            for (Element element : listElement) {
                testMessageMap.put(element.getName(), element.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return testMessageMap;
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: message 转 xml 对象
     * @Date: 2018/2/5 16:06
     */
    public static String textMessageToXml(TextMessagePOJO textMessagePOJO) {
        XStream xstream = new XStream();
        //设置生成的xml文档的根元素 为xml ，官方文档需要
        xstream.alias("xml", TextMessagePOJO.class);
        String message = xstream.toXML(textMessagePOJO);
        return message;
    }

    //初始化回复的信息 都是text类型  拼接文本消息
    public static String intiText(String toUserName, String fromUserName, String content) {
        TextMessagePOJO message = new TextMessagePOJO();
        message.setContent(content);
        message.setCreateTime(new Date().getTime() + "");
        message.setFromUserName(toUserName);
        message.setToUserName(fromUserName);
        message.setMsgType(MessageUtils.MESSAGE_TEXT);
        return MessageUtils.textMessageToXml(message);
    }
    
    /**
     * @Author: Jiang Jiahong
     * @Description: 关注时候回复的信息
     * @Date: 2018/2/6 13:21
     */
    public static String subscribeText() {
        StringBuffer sb = new StringBuffer();
        sb.append("亲，您终于来了，小编在此恭候多时！\n\n");
        sb.append("金源课堂旨在：\n");
        sb.append("1.改变传统课堂签到方式\n");
        sb.append("2.提高课堂签到便利性\n\n");
        sb.append("tips：\n");
        sb.append("[进入课堂]是用户操作的入口\n");
        sb.append("[帮助中心]可查看用户使用手册\n");
        return sb.toString();
    }

   
}
