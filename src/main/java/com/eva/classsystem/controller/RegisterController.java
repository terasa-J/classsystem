package com.eva.classsystem.controller;

import com.eva.classsystem.pojo.Student;
import com.eva.classsystem.pojo.Teacher;
import com.eva.classsystem.service.StudentService;
import com.eva.classsystem.service.StudentServiceImpl;
import com.eva.classsystem.service.TeacherServiceImpl;
import com.eva.classsystem.utils.RoleUtills;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: Jiang Jiahong
 * @Description: 处理 “注册”业务  包括（学生&老师）
 * @Date: 2018/1/12 10:19
 */
@Controller
public class RegisterController {
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    TeacherServiceImpl teacherService;


    /**
     * @Author: Jiang Jiahong
     * @Description: 注册为学生
     * @Date: 2018/1/12 17:52
     */
    @PostMapping(value = "/registerStu")
    public String registerStu(HttpServletRequest request, Model model) {
        //1.先判断验证码
        boolean isVerify = vaildCode(request, model);
        if (!isVerify) {
            return "register/registerStu";
        } else {
            //3.新建学生用户
            Student student = (Student) getUserInfo(request, RoleUtills.STUDENT);
            //4.插入数据
            studentService.insert(student);
            return "login";
        }
    }

    /**
     * @Author: Jiang  Jiahong
     * @Description: 注册为教师
     * @Date: 2018/1/13 16:37
     */
    @PostMapping(value = "/registerSir")
    public String registerSir(HttpServletRequest request, Model model) {
        //1.先判断验证码
        boolean isVerify = vaildCode(request, model);
        if (!isVerify) {
            return "register/registerSir";
        } else {
            //3.新建教师用户
            Teacher teacher = (Teacher) getUserInfo(request, RoleUtills.TEACHER);
            //4.插入数据
            teacherService.insert(teacher);
            return "login";
        }
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 验证码验证
     * @Date: 2018/1/13 16:40
     */
    public boolean vaildCode(HttpServletRequest request, Model model) {
        //1.先判断验证码
        String sessionVerifyCode = (String) request.getSession().getAttribute("verifyCode");
        String verifyCode = request.getParameter("verifyCode");
        if (!sessionVerifyCode.equalsIgnoreCase(verifyCode)) {
            model.addAttribute("tipInfo", "验证码输入错误");
            return false;
        } else {
            model.addAttribute("tipInfo", "注册成功,请登录");
            return true;
        }
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 获取信息
     * @Date: 2018/1/13 17:15
     */
    public Object getUserInfo(HttpServletRequest request, String role) {
        //2.获取用户信息
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String userID = request.getParameter("userID");
        String school = request.getParameter("school");
        if (RoleUtills.TEACHER.equalsIgnoreCase(role)) {
            //3.新建教师用户
            Teacher teacher = new Teacher();
            teacher.setEmail(email);
            teacher.setPassword(password);
            teacher.setName(name);
            teacher.setSirid(userID);
            teacher.setSchool(school);
            teacher.setHeadimg("img/myself/head.png");
            return teacher;
        } else if (RoleUtills.STUDENT.equalsIgnoreCase(role)) {
            //截取班级号
            String classNo = userID.substring(0, 7);   //从0开始截取到6为止
            //获取专业
            String major = request.getParameter("major");
            //3.新建学生用户
            Student student = new Student();
            student.setEmail(email);
            student.setPassword(password);
            student.setName(name);
            student.setStuid(userID);
            student.setCalssno(classNo);
            student.setSchool(school);
            student.setMajor(major);
            student.setHeadimg("img/myself/head.png");
            return student;
        }
        return null;
    }
}
