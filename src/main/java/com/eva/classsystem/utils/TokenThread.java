package com.eva.classsystem.utils;

import com.eva.classsystem.pojo.weChatPojo.AccessTokenPOJO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author: Jiang Jiahong
 * @Description: 定时获取微信access_token的线程
 * @Date: 2018/2/6 13:45
 */
public class TokenThread implements Runnable {
    private static Logger log = LoggerFactory.getLogger(TokenThread.class);
    public static AccessTokenPOJO accessTokenPOJO = null;

    public void run() {
        while (true) {
            try {
                accessTokenPOJO = WeChatUtils.getAccessToken();
                if (null != accessTokenPOJO) {
                    log.info("获取access_token成功，有效时长{}秒 token:{}", accessTokenPOJO.getExpires_in(), accessTokenPOJO.getAccess_token());
                    // 休眠7000秒
                    Thread.sleep((Integer.parseInt(accessTokenPOJO.getExpires_in()) - 200) * 1000);
                } else {
                    // 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    log.error("{}", e1);
                }
                log.error("{}", e);
            }
        }
    }
}