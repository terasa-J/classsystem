package com.eva.classsystem.controller;

import com.eva.classsystem.pojo.Student;
import com.eva.classsystem.pojo.Teacher;
import com.eva.classsystem.service.StudentServiceImpl;
import com.eva.classsystem.service.TeacherServiceImpl;
import com.eva.classsystem.utils.RoleUtills;
import com.eva.classsystem.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Jiang Jiahong
 * @Description: 忘记密码业务处理
 * @Date: 2018/1/22 12:56
 */
@Controller
public class ForgetPwController {
    private static final Logger logger = LoggerFactory.getLogger(ForgetPwController.class);
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    TeacherServiceImpl teacherService;

    @PostMapping(value = "/forgetPassword")
    public String forgetPassword(HttpServletRequest request, Model model) throws Exception {
        String userID = request.getParameter("userID");
        String role = request.getParameter("role");
        String tipInfo = "请登录邮箱查看新密码！";
        //教师
        if (RoleUtills.TEACHER.equalsIgnoreCase(role)) {
            //1.查询是否有该教师号
            Teacher teacher = teacherService.selectBySirID(userID);
            if (null != teacher) {
                //2.获取该用户邮箱
                String sirEmail = teacher.getEmail();
                //3.发新密码邮件到该邮箱
                Utils.sendEmail(sirEmail,"",false,null);
                logger.info("-----------sendEmail---------");
                //4.修改数据库中的密码
                teacher.setPassword("66668888");
                teacherService.updateByPrimaryKey(teacher);
            } else {
                // 不存在该教师
                tipInfo = "没有该帐号，请确认无误再输入！";
            }
        //学生
        } else if (RoleUtills.STUDENT.equalsIgnoreCase(role)) {
            //1.查询是否有该学号
            Student student = studentService.selectByStuID(userID);
            if (null != student) {
                //2.获取学生邮箱
                String stuEmail = student.getEmail();
                //3.发新密码邮件到该邮箱
                Utils.sendEmail(stuEmail,"",false,null);
                //4.修改数据库中的密码
                student.setPassword("66668888");
                studentService.updateByPrimaryKey(student);
            } else {
                //不存在该学生
                tipInfo = "没有该帐号，请确认无误再输入！";
            }
        }
        //5.给用户显示提示信息
        model.addAttribute("tipInfo", tipInfo);
        return "forgetPassword";
    }

}
