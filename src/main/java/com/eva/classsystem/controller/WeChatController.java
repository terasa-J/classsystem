package com.eva.classsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.eva.classsystem.pojo.weChatPojo.AccessReqPOJO;
import com.eva.classsystem.utils.WeChatUtils;
import com.eva.classsystem.utils.CheckAccessUtils;
import com.eva.classsystem.utils.MessageUtils;
import com.eva.classsystem.utils.TokenThread;
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
public class WeChatController {
    /**
     * @Author: Jiang Jiahong
     * @Description: 微信端服务器验证 连接微信
     * @Date: 2018/2/5 17:12
     */
    @GetMapping(value = "/checkSignature")
    public @ResponseBody String checkSignature(HttpServletRequest request ) throws IOException {
        //2.初始化菜单
        String menu = JSONObject.toJSONString(WeChatUtils.getMenu()).toString();
        int result = WeChatUtils.createMenu(TokenThread.accessTokenPOJO.getAccess_token(), menu);
        if(result == 0){
            System.out.println("菜单创建成功");
        }else{
            System.out.println("菜单创建失败");
        }

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
    @PostMapping(value = "/checkSignature")
    public @ResponseBody String testMessage( HttpServletRequest request ){
        //1.获得用户发送的文字，把xml解析成Map
        Map< String,String > textMap = MessageUtils.xmlToTextMessage( request );
        //2.获得相应字段
        String msgType = textMap.get("MsgType");
        String content = textMap.get("Content");
        String createTime = textMap.get("CreateTime");
        String toUserName = textMap.get("ToUserName");
        String fromUserName = textMap.get("FromUserName");
        String msgId = textMap.get("MsgId");
        //3.判断消息类型
        String result = null;
        if (MessageUtils.MESSAGE_EVENT.equals(msgType) ){
            //事件类型中有  关注事件 与 取消关注事件
            String event = textMap.get("Event");
            //4.用户关注事件
            if( MessageUtils.MESSAGE_SUBSCRIBE.equals(event) ){
                result = MessageUtils.intiText(toUserName, fromUserName, MessageUtils.subscribeText());
            }
        }
        return result;
    }
}
