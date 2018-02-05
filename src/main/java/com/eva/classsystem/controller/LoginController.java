package com.eva.classsystem.controller;

import com.eva.classsystem.pojo.Course;
import com.eva.classsystem.pojo.Student;
import com.eva.classsystem.pojo.Teacher;
import com.eva.classsystem.service.CourseServiceImpl;
import com.eva.classsystem.service.StudentServiceImpl;
import com.eva.classsystem.service.TeacherServiceImpl;
import com.eva.classsystem.utils.RoleUtills;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description: 用户登录
 * @Date: 2018/1/13 17:25
 */
@Controller
public class LoginController {
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    CourseController courseController;
    /**
     * @Author: Jiang Jiahong
     * @Description: 用户登录
     * @Date: 2018/1/13 17:57
     */
    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, Model model) {
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String tipInfo = "";
        if (RoleUtills.TEACHER.equalsIgnoreCase(role)) {
            Teacher teacher = teacherService.selectBySirID(userID);
            //1.判断是否存在该用户
            if (null != teacher) {
                String sirPass = teacher.getPassword();
                //2.判断密码是否错误
                if (sirPass.equals(password)) {
                    request.getSession().setAttribute("user", teacher);
                    request.getSession().setAttribute("userRole", RoleUtills.TEACHER);
                    //查询老师班级信息
                    return courseController.getSirClass(request,model);

                } else {
                    tipInfo = "密码输入错误";
                }
            } else {
                tipInfo = "不存在该用户";
            }
        } else if (RoleUtills.STUDENT.equalsIgnoreCase(role)) {
            Student student = studentService.selectByStuID(userID);
            //1.判断是否存在该用户
            if (null != student) {
                String stuPass = student.getPassword();
                //2.判断密码是否错误
                if (stuPass.equals(password)) {
                    request.getSession().setAttribute("user", student);
                    request.getSession().setAttribute("userRole", RoleUtills.STUDENT);
                    //查询学生班级信息
                    return courseController.getStuClass(request,model);
                } else {
                    tipInfo = "密码输入错误";
                }
            } else {
                tipInfo = "不存在该用户";
            }
        }
        model.addAttribute("tipInfo", tipInfo);
        return "login";
    }

}
