package com.eva.classsystem.utils;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.eva.classsystem.pojo.Attendance;
import com.eva.classsystem.pojo.StuAttendanceInfo;
import com.eva.classsystem.pojo.Student;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;

/**
 * @Author: Jiang Jiahong
 * @Description: 工具类
 * @Date: 2018/1/9 15:40
 */
@Component
public class Utils {
    /**
     * @Author: Jiang Jiahong
     * @Description: 验证码 Kaptcha组件
     * @Date: 2018/1/22 16:08
     */
    @Bean
    public DefaultKaptcha getDefaultKaptcha() {
        com.google.code.kaptcha.impl.DefaultKaptcha defaultKaptcha = new com.google.code.kaptcha.impl.DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "no");
        properties.setProperty("kaptcha.border.color", "105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.textproducer.font.size", "40");
        properties.setProperty("kaptcha.session.key", "code");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 发送邮件 （忘记密码）
     * @Date: 2018/1/22 16:09
     */

    public static void sendEmail(String toUser,String excelName,boolean isAttendance,InputStream inputStream) throws Exception {
        String fromUser = "475890319@qq.com";
        String password = "gxecscybexjsbiei";
        //1.创建连接对象，连接到对象服务器
        Properties properties = new Properties();
        //1.1 发送邮件协议
        properties.setProperty("mail.transport.protocol", "smtp");
        //1.2 需要验证
        properties.setProperty("mail.smtp.auth", "true");
        //1.3 设置debug模式 后台输出邮件发送的过程
        properties.setProperty("mail.debug", "true");
        Session session = Session.getInstance(properties);
        session.setDebug(true);//debug模式

        //2.创建邮件对象
        Message message = new MimeMessage(session);
        //2.1 设置发送人
        message.setFrom(new InternetAddress(fromUser));
        //设置自定义发件人昵称
        String nick = javax.mail.internet.MimeUtility.encodeText("金院课堂");
        message.setFrom(new InternetAddress(nick + " <" + fromUser + ">"));
        //2.2 设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toUser));
        message.addHeader("charset", "UTF-8");
         /*添加正文内容*/
        Multipart multipart = new MimeMultipart();
        BodyPart contentPart = new MimeBodyPart();

        if(isAttendance){
            message.setSubject("金院课堂——导出考勤信息");
            //导出考勤情况
            contentPart.setText("详细考情信息请查看附件");
            /*添加附件*/
            MimeBodyPart fileBody = new MimeBodyPart();
            DataSource source = new ByteArrayDataSource(inputStream, "application/msexcel");
            fileBody.setDataHandler(new DataHandler(source));
            String fileName  = excelName+".xls";
            // 中文乱码问题
            fileBody.setFileName(MimeUtility.encodeText(fileName));
            multipart.addBodyPart(fileBody);
        }else{
            //忘记密码
            //2.3 设置邮件主题
            message.setSubject("金院课堂——重新设置密码");
            //2.4 设置邮件内容
            contentPart.setText("系统已经为您重新设置  新密码：666888(请您登录后再重新设置)");
        }
        contentPart.setHeader("Content-Type", "text/html; charset=UTF-8");
        multipart.addBodyPart(contentPart);
        message.setSentDate(new Date());
        message.setContent(multipart);
        message.saveChanges();

        //3.发送邮件
        Transport tran = session.getTransport();
        //3.1 连接到QQ邮箱服务器
        tran.connect("smtp.qq.com", 587, fromUser, password);
        //3.2 设置邮件接收人
        tran.sendMessage(message, new Address[]{new InternetAddress(toUser)});
        tran.close();
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 上传图片
     * @Date: 2018/1/25 15:58
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 获取当前时间
     * @Date: 2018/1/26 14:11
     */
    public static String getDate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 生成邀请码
     * @Date: 2018/1/26 14:20
     */
    public static String getInvitationCode() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(26);
            stringBuffer.append(str.charAt(num));
        }
        return stringBuffer.toString();
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 生成4为数字签到码
     * @Date: 2018/1/29 14:56
     */
    public static String getAttendanceCode() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * 10);
            stringBuffer.append(num);
        }
        return stringBuffer.toString();
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 导出数据生成Excel
     * @Date: 2018/1/30 18:09
     */
    public static void createExcel(Attendance attendance, List<StuAttendanceInfo> stuAttendanceList, List<Student> notAttendStuList,String toUser) {
        // 建立一个Excel
        Workbook book = new HSSFWorkbook();
        HSSFCellStyle hssfCellStyle = (HSSFCellStyle) book.createCellStyle();
        Font font = book.createFont();
        // 在对应的Excel中建立一个分表
        Sheet sheet = book.createSheet("考勤情况");
        Row row = null;
        Cell cell = null;

        //初始行数据
        List<String> title = new ArrayList<>();
        title.add("考勤名字:");
        title.add("应到:");
        title.add("实到:");
        title.add("缺勤:");
        List<String> titleValue = new ArrayList<>();
        titleValue.add(attendance.getName());
        titleValue.add(attendance.getActualnumber().toString());
        titleValue.add(stuAttendanceList.size() + "");
        titleValue.add(Math.abs(attendance.getActualnumber()-stuAttendanceList.size())+"");
       //写入 Excel
        for (int i = 0; i < title.size(); i++) {
            // 设置相应的行（初始从0开始）
            row = sheet.createRow(i);
            // 在所在的行设置所在的单元格（相当于列，初始从0开始,对应的就是A列）
            cell = row.createCell(0);
            // 写入相关数据到设置的行列中去。
            cell.setCellValue(title.get(i));
            cell = row.createCell(1);
            cell.setCellValue(titleValue.get(i));
        }
        // 具体考勤数据
        List<String> titleStu = new ArrayList<>();
        titleStu.add("学号");
        titleStu.add("姓名");
        titleStu.add("GPS定位");
        titleStu.add("考勤情况");
        //隔一行  具体考勤数据
        row = sheet.createRow(5);
        for (int i = 0; i < titleStu.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(titleStu.get(i));
        }

        //出勤
        for (int i = 0; i < stuAttendanceList.size(); i++) {
            row = sheet.createRow(i + 6);
            // 单元格0:学号
            cell = row.createCell(0);
            cell.setCellValue(stuAttendanceList.get(i).getStuid());
            // 单元格1:姓名
            cell = row.createCell(1);
            cell.setCellValue(stuAttendanceList.get(i).getName());
            // 单元格2:GPS定位
            cell = row.createCell(2);
            cell.setCellValue(stuAttendanceList.get(i).getLocation());
            // 单元格3:出勤情况
            cell = row.createCell(3);
            cell.setCellValue("出勤");
        }
        //缺勤
        for (int i = 0; i < notAttendStuList.size(); i++) {
            //设置颜色字体为红色
            font.setColor(HSSFColor.RED.index);
            hssfCellStyle.setFont(font);
            //行号
            row = sheet.createRow(i + stuAttendanceList.size() + 6 );
            // 单元格0:学号
            cell = row.createCell(0);
            cell.setCellValue(notAttendStuList.get(i).getStuid());
            // 单元格1:姓名
            cell = row.createCell(1);
            cell.setCellValue(notAttendStuList.get(i).getName());
            // 单元格2:GPS定位
            cell = row.createCell(2);

            // 单元格3:出勤情况
            cell = row.createCell(3);
            cell.setCellValue("缺勤");
            cell.setCellStyle(hssfCellStyle);

        }

        // 转换字节流
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            book.write(baos);
            baos.flush();
            byte[] bt = baos.toByteArray();
            InputStream is = new ByteArrayInputStream(bt, 0, bt.length);
            baos.close();
            //发送邮件
            sendEmail(toUser,attendance.getName(),true,is);
           // book.write(new FileOutputStream("F://a.xls"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
