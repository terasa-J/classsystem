package com.eva.classsystem.controller;

import com.eva.classsystem.pojo.weChat.AccessReqPOJO;
import com.eva.classsystem.utils.CheckAccessUtils;
import com.eva.classsystem.utils.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: Jiang Jiahong
 * @Description: 微信公众号 验证
 * @Date: 2018/2/5 15:53
 */
@Controller
public class weChatController {
    @GetMapping("/checkSignature")
    public @ResponseBody
    String checkSignature(HttpServletRequest request ) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        AccessReqPOJO accessReqPOJO = new AccessReqPOJO();
        accessReqPOJO.setEchostr(echostr);
        accessReqPOJO.setNonce(nonce);
        accessReqPOJO.setSignature(signature);
        accessReqPOJO.setTimestamp(timestamp);

        //校验
        if( CheckAccessUtils.checkSignatrue( accessReqPOJO ) ){
            return accessReqPOJO.getEchostr();
        }
        return "error";
    }

    //接收文本信息POST并回复
    @PostMapping("/checkSignature")
    public @ResponseBody String testMessage( HttpServletRequest request ){
        Map< String,String > textMap = MessageUtils.xmlToTextMessage( request );
        String msgType = textMap.get("MsgType");
        String content = textMap.get("Content");
        String createTime = textMap.get("CreateTime");
        String toUserName = textMap.get("ToUserName");
        String fromUserName = textMap.get("FromUserName");
        String msgId = textMap.get("MsgId");

        String result = null;
        if( MessageUtils.MESSAGE_TEXT.equals( msgType ) ){
            if("1".equals(content)){
                result = MessageUtils.intiText(toUserName, fromUserName, MessageUtils.firstMenu());
            }else if("2".equals(content)){
                result = MessageUtils.intiText(toUserName, fromUserName, MessageUtils.secondMenu());
            }else if("?".equals(content)){
                result = MessageUtils.intiText(toUserName, fromUserName, MessageUtils.menuText());
            }else if("3".equals(content)){
                result = MessageUtils.initNewsMessage(toUserName, fromUserName);
            }

            //	System.out.println("回复的xml文档\r\n"+ result );
        }else if (MessageUtils.MESSAGE_EVENT.equals(msgType) ){
            //事件类型中有  关注事件 与 取消关注事件
            String event = textMap.get("Event");
            if( MessageUtils.MESSAGE_SUBSCRIBE.equals(event) ){
                result = MessageUtils.intiText(toUserName, fromUserName, MessageUtils.menuText());
            }
        }
        return result;
    }
}
