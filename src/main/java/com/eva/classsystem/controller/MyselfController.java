package com.eva.classsystem.controller;

import com.eva.classsystem.pojo.Student;
import com.eva.classsystem.pojo.Teacher;
import com.eva.classsystem.service.StudentServiceImpl;
import com.eva.classsystem.service.TeacherServiceImpl;
import com.eva.classsystem.utils.RoleUtills;
import com.eva.classsystem.utils.Utils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @Author: Jiang Jiahong
 * @Description: “我”这一板块
 * @Date: 2018/1/22 17:21
 */
@Controller
public class MyselfController {
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    StudentServiceImpl studentService;
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyselfController.class);

    @PostMapping(value = "/myself")
    public String myself(HttpServletRequest request, Model model) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "myself/myself";
    }
       /**
     * @Author: Jiang Jiahong
     * @Description: 帐号界面
     * @Date: 2018/1/23 12:20
     */
    @PostMapping(value = "/account")
    public String accountPage(HttpServletRequest request, Model model) {
        //获得帐号、邮箱
        basicInfo(request, model);
        return "myself/account/account";
    }
/** --------------------------------------------邮箱设置业务 -------------------------------------------------**/
    /**
     * @Author: Jiang Jiahong
     * @Description: 邮箱 界面
     * @Date: 2018/1/23 14:44
     */
    @PostMapping(value = "/email")
    public String emailPage(HttpServletRequest request, Model model) {
        //获得邮箱
        basicInfo(request, model);
        return "myself/account/email";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 更换邮箱
     * @Date: 2018/1/23 15:06
     */
    @PostMapping(value = "/changeEmail")
    public String changeEmail(HttpServletRequest request, Model model) {
        //获得邮箱
        basicInfo(request, model);
        return "myself/account/changeEmail";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 保存更换邮箱
     * @Date: 2018/1/23 15:25
     */
    @PostMapping(value = "/confirmChangeEmail")
    public String confirmChangeEmail(HttpServletRequest request, Model model) {
        //1.获得新邮箱
        String email = request.getParameter("email");
        String tipInfo = "更改邮箱成功!";
        String path = "myself/account/changeEmail";
        //2.判断是否输入为空
        if (null == email || "".equalsIgnoreCase(email)) {
            tipInfo = "新邮箱不能为空！";
            //保留旧邮箱
            basicInfo(request, model);
        } else {
            //3.判断角色
            String role = (String) request.getSession().getAttribute("userRole");
            //4.修改数据库
            changeEmail(request, email);
            //5.保存新邮箱返回到页面
            model.addAttribute("email", email);
            path = "myself/account/email";
        }
        model.addAttribute("tipInfo", tipInfo);
        return path;
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 确定解绑邮箱
     * @Date: 2018/1/23 17:23
     */
    @PostMapping(value = "/confirmUnbindEmail")
    public String confirmUnbindEmail(HttpServletRequest request, Model model) {
        String email = "未绑定邮箱";
        changeEmail(request, email);
        //返回新数据到页面
        model.addAttribute("email", email);
        model.addAttribute("tipInfo", "解绑成功");
        return "myself/account/email";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 判断教师 还是 学生 ，获得基本信息
     * @Date: 2018/1/23 14:46
     */
    public String basicInfo(HttpServletRequest request, Model model) {
        String role = (String) request.getSession().getAttribute("userRole");
        if (RoleUtills.TEACHER.equalsIgnoreCase(role)) {
            Teacher teacher = (Teacher) request.getSession().getAttribute("user");
            //由于数据库中userID的字段不一样 所以选择存取字段的方式返回页面
            model.addAttribute("userID", teacher.getSirid());
            model.addAttribute("email", teacher.getEmail());
            model.addAttribute("name", teacher.getName());
            model.addAttribute("school", teacher.getSchool());
            model.addAttribute("headimg", teacher.getHeadimg());
        } else if (RoleUtills.STUDENT.equalsIgnoreCase(role)) {
            Student student = (Student) request.getSession().getAttribute("user");
            model.addAttribute("userID", student.getStuid());
            model.addAttribute("email", student.getEmail());
            model.addAttribute("name", student.getName());
            model.addAttribute("school", student.getSchool());
            model.addAttribute("classNo", student.getCalssno());
            model.addAttribute("major", student.getMajor());
            model.addAttribute("headimg", student.getHeadimg());
        }
        return role;
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 修改邮箱
     * @Date: 2018/1/23 17:21
     */
    public void changeEmail(HttpServletRequest request, String email) {
        //1.先判断角色
        String role = (String) request.getSession().getAttribute("userRole");
        //2.修改数据库中邮箱数据
        if (RoleUtills.TEACHER.equalsIgnoreCase(role)) {
            Teacher teacher = (Teacher) request.getSession().getAttribute("user");
            teacher.setEmail(email);
            teacherService.updateByPrimaryKey(teacher);
        } else if (RoleUtills.STUDENT.equalsIgnoreCase(role)) {
            Student student = (Student) request.getSession().getAttribute("user");
            student.setEmail(email);
            studentService.updateByPrimaryKey(student);
        }
    }
/** --------------------------------------------密码设置业务 -------------------------------------------------**/
    /**
     * @Author: Jiang Jiahong
     * @Description: 设置密码界面
     * @Date: 2018/1/23 17:35
     */
    @GetMapping("/setPassword")
    public String resetPassword() {
        return "myself/account/setPassword";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 确认修改密码
     * @Date: 2018/1/23 18:10
     */
    @PostMapping("/resetPassword")
    public String confirmResetPassword(HttpServletRequest request, Model model) {
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String newPassConfirm = request.getParameter("newPassConfirm");
        String tipInfo = "密码修改成功";
        String path = "myself/account/account";
        //1.判断角色
        String role = (String) request.getSession().getAttribute("userRole");
        if (RoleUtills.TEACHER.equalsIgnoreCase(role)) {
            Teacher teacher = (Teacher) request.getSession().getAttribute("user");
            //2.验证旧密码是否错误
            String password = teacher.getPassword();
            boolean isRight = checkPassword(password, oldPass, newPass, newPassConfirm, tipInfo, model);
            if (!isRight) {
                return "myself/account/setPassword";
            }
            //4.修改密码
            teacher.setPassword(newPass);
            teacherService.updateByPrimaryKey(teacher);
        } else if (RoleUtills.STUDENT.equalsIgnoreCase(role)) {
            Student student = (Student) request.getSession().getAttribute("user");
            String password = student.getPassword();
            boolean isRight = checkPassword(password, oldPass, newPass, newPassConfirm, tipInfo, model);
            if (!isRight) {
                return "myself/account/setPassword";
            }
            student.setPassword(newPass);
            studentService.updateByPrimaryKey(student);
        }
        //5.返回提示信息给页面
        model.addAttribute("tipInfo", tipInfo);
        //基本信息
        basicInfo(request, model);
        return path;
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 验证密码输入是否正确
     * @Date: 2018/1/23 20:03
     */
    public boolean checkPassword(String password, String oldPass, String newPass, String newPassConfirm, String tipInfo, Model model) {
        boolean isRight = true;
        //2.1 密码输入为空
        if (null == oldPass || oldPass.length() == 0 ||
                null == newPass || newPass.length() == 0 ||
                null == newPassConfirm || newPassConfirm.length() == 0) {
            tipInfo = "密码不能为空";
            isRight = false;
        }

        //2.2 验证旧密码失败
        if (!password.equals(oldPass)) {
            tipInfo = "旧密码验证失败，请重新输入";
            isRight = false;
        }
        //3.判断2次密码是否正确
        //3.1 2次密码输入不正确
        if (!newPass.equals(newPassConfirm)) {
            tipInfo = "2次密码输入不正确，请重新输入";
            isRight = false;
        }
        model.addAttribute("tipInfo", tipInfo);
        return isRight;
    }

/**------------------------------------------------------个人信息设置业务-------------------------------------***/
    /**
     * @Author: Jiang Jiahong
     * @Description: 个人信息
     * @Date: 2018/1/23 14:23
     */
    @PostMapping(value = "/personInfo")
    public String personInfoPage(HttpServletRequest request, Model model) {
        String role = (String) request.getSession().getAttribute("userRole");
        String path = "";
        if (RoleUtills.TEACHER.equalsIgnoreCase(role)) {
            path = "myself/personInfo/sirPersonInfo";
        } else if (RoleUtills.STUDENT.equalsIgnoreCase(role)) {
            path = "myself/personInfo/stuPersonInfo";
        }
        basicInfo(request, model);
        return path;
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 设置头像
     * @Date: 2018/1/24 12:27
     */
    @GetMapping(value = "/setHeadImg")
    public String setHeadImgPage() {
        return "myself/personInfo/headImg";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 确认上传图片
     * @Date: 2018/1/25 16:40
     */
    @PostMapping(value = "/setHeadImg")
    public String confirmSetImg(@RequestParam("file") MultipartFile file, HttpServletRequest request,Model model) throws Exception {
        //前端传来的是压缩后的并用base64编码后的字符串
        String imgUrl = request.getParameter("imgUrl").toString();
        //需要去掉头部信息，这很重要
        imgUrl = imgUrl.substring(imgUrl.indexOf(",") + 1);
        // 获得一个图片文件流，我这里是从flex中传过来的
        BASE64Decoder base64Decoder = new BASE64Decoder();
        //解码
        byte[] imgByte = base64Decoder.decodeBuffer(imgUrl);
        //新建一个存放图片的路径，由于业务少，直接存放在服务器端口
        String filePath = request.getSession().getServletContext().getRealPath("upload_headImg/");
        String fileName = file.getOriginalFilename();
        try {
            Utils.uploadFile(imgByte, filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //设置保存到数据库中
        String role = (String) request.getSession().getAttribute("userRole");
        String headImg = "upload_headImg/" + fileName;
        if (RoleUtills.TEACHER.equalsIgnoreCase(role)) {
            Teacher teacher = (Teacher) request.getSession().getAttribute("user");
            teacher.setHeadimg(headImg);
            teacherService.updateByPrimaryKey(teacher);
        } else if (RoleUtills.STUDENT.equalsIgnoreCase(role)) {
            Student student = (Student) request.getSession().getAttribute("user");
            student.setHeadimg(headImg);
            studentService.updateByPrimaryKey(student);
        }
        model.addAttribute("tipInfo","上传头像成功");
        return personInfoPage(request,model);

    }
}
