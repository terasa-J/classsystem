package com.eva.classsystem.utils;

import com.eva.classsystem.pojo.weChatPojo.AccessReqPOJO;

import java.security.MessageDigest;
import java.util.Arrays;


/*开发者通过检验signature对请求进行校验（下面有校验方式）。
 * 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。
 * 加密/校验流程如下：
 1）将token、timestamp、nonce三个参数进行字典序排序

2）将三个参数字符串拼接成一个字符串进行sha1加密

3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信

 */

/**
 * @Author: Jiang Jiahong
 * @Description: 校验服务器是否连接成功
 * @Date: 2018/2/6 13:17
 */
public class CheckAccessUtils {
    //开发者模式-开发者自己填写的 token （令牌）
    private static final String token = "myToken";

    public static boolean checkSignatrue(AccessReqPOJO accessReqPOJO) {
        //1.将token、timestamp、nonce三个参数进行字典序排序
        String[] arrs = new String[]{token, accessReqPOJO.getTimestamp(), accessReqPOJO.getNonce()};
        Arrays.sort(arrs);

        //2.将三个参数字符串拼接成一个字符串,进行sha1加密
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < arrs.length; i++) {
            strBuffer.append(arrs[i]);
        }
        String str = getSha1(strBuffer.toString());

        //3.加密后的字符串与signature对比，标识该请求来源于微信
        return str.equalsIgnoreCase(accessReqPOJO.getSignature());
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 使用原始的sha1 加密代码      weChat提交成功
     * @Date: 2018/2/6 13:17
     */
    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }

}
