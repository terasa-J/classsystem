package com.eva.classsystem.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Jiang Jiahong
 * @Description: 纯展示的页面
 * @Date: 2018/1/12 10:05
 */
@Controller
public class HomeController {
    @GetMapping(value = "/home")
    public String home() {
        return "login";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 注册首页（纯展示）
     * @Date: 2018/1/12 10:25
     */
    @GetMapping(value = "/register/registerHome")
    public String registerHome() {
        return "register/registerHome";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 注册为学生 （纯展示）
     * @Date: 2018/1/12 10:34
     */
    @GetMapping(value = "/register/registerStu")
    public String registerToStu() {
        return "register/registerStu";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 注册为老师（纯展示）
     * @Date: 2018/1/12 10:36
     */
    @GetMapping(value = "/register/registerSir")
    public String registerToSir() {
        return "register/registerSir";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 忘记密码
     * @Date: 2018/1/22 12:44
     */
    @GetMapping(value = "/forgetPassword")
    public String forgetPassword() {
        return "forgetPassword";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 教师创建班级
     * @Date: 2018/1/26 13:54
     */
    @GetMapping(value = "/createClass")
    public String createClass() {
        return "teacher/createClass";
    }

}
