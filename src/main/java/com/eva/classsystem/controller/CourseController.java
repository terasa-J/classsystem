package com.eva.classsystem.controller;

import com.eva.classsystem.pojo.*;
import com.eva.classsystem.service.CourseServiceImpl;
import com.eva.classsystem.service.StudentCourseServiceImpl;
import com.eva.classsystem.utils.RoleUtills;
import com.eva.classsystem.utils.Utils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description: 教师拥有业务
 * @Date: 2018/1/26 13:52
 */
@Controller
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;
    @Autowired
    StudentCourseServiceImpl studentCourseService;

    /**
     * @Author: Jiang Jiahong
     * @Description: 跳转到用户课堂页面
     * @Date: 2018/1/26 16:15
     */
    @PostMapping(value = "/getUserCoursePage")
    public String getUserCoursePage(HttpServletRequest request, Model model) {
        String role = (String) request.getSession().getAttribute("userRole");
        if (RoleUtills.TEACHER.equalsIgnoreCase(role)) {
            return getSirClass(request, model);
        } else if (RoleUtills.STUDENT.equalsIgnoreCase(role)) {
            return getStuClass(request, model);
        }
        return "";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 获得全部班级（老师）
     * @Date: 2018/1/26 14:46
     */
    @PostMapping(value = "/getSirClass")
    public String getSirClass(HttpServletRequest request, Model model) {
        List<Course> courseList = getSirCourseList(request);
        model.addAttribute("courseList", courseList);
        return "teacher/sirClass";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 确认新建班级（老师）
     * @Date: 2018/1/26 16:24
     */
    @PostMapping(value = "/confirmCreateClass")
    public String confirmCreateClass(HttpServletRequest request, Model model) {
        String className = request.getParameter("className");
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        String sirID = teacher.getSirid();
        String createTime = Utils.getDate();
        String invitationCode = Utils.getInvitationCode();
        //courseID 主键 这里采用邀请码一样的数值
        String courseID = request.getParameter("courseID");
        //获得基本信息
        Course course = new Course();
        course.setInvitationcode(invitationCode);
        course.setSirid(sirID);
        course.setCname(className);
        course.setCreatetime(createTime);
        course.setCourseid(courseID);
        //插入数据
        courseService.insert(course);
        return getSirClass(request, model);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 编辑班级信息（老师）
     * @Date: 2018/1/26 16:25
     */
    @GetMapping(value = "/updateClass")
    public String updateClass(HttpServletRequest request, Model model) {
        Course course = getCourseByStatusIndex(request);
        model.addAttribute("course", course);
        return "teacher/updateClass";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 确认修改班级信息 （老师）
     * @Date: 2018/1/26 16:50
     */
    @PostMapping(value = "/confirmUpdateClass")
    public String confirmUpdateClass(HttpServletRequest request, Model model) {
        //1.获得修改的班级名字
        String cname = request.getParameter("cname");
        //2.获得要修改的班级
        Course course = getCourseByCourseID(request);
        String cnameFirst = course.getCname();
        // 当修改一致则不去修改数据库
        if (!cname.equals(cnameFirst)) {
            course.setCname(cname);
            //3.修改数据
            courseService.updateByPrimaryKey(course);
        }
        model.addAttribute("tipInfo", "修改班级成功");
        return getSirClass(request, model);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 确认删除班级（老师）
     * @Date: 2018/1/27 11:51
     */
    @GetMapping(value = "/confirmDeleteCourse")
    public String confirmDeleteCourse(HttpServletRequest request, Model model) {
        Course course = getCourseByStatusIndex(request);
        //4.修改数据
        String courseID = course.getCourseid();
        if (0 != courseService.deleteByCourseID(courseID)) {
            model.addAttribute("tipInfo", "删除班级成功");
        } else {
            model.addAttribute("tipInfo", "删除班级失败");
        }
        return getSirClass(request, model);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 根据 status.index 获得班级
     * @Date: 2018/1/27 11:53
     */
    public Course getCourseByStatusIndex(HttpServletRequest request) {
        //1.获得选中的课堂下标
        String index = request.getParameter("index");
        int indexCourse = Integer.parseInt(index);
        //2.获得全部列表
        List<Course> courseList = getSirCourseList(request);
        //3. 获得要修改的课堂
        Course course = courseList.get(indexCourse);
        return course;
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 根据CourseID 获得某一班级
     * @Date: 2018/1/26 16:53
     */
    public Course getCourseByCourseID(HttpServletRequest request) {
        String courseid = request.getParameter("courseid");
        Course course = courseService.selectByCourseID(courseid);
        return course;
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 获得老师ID
     * @Date: 2018/1/29 14:25
     */
    public String getSirId(HttpServletRequest request){
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        String sirID = teacher.getSirid();
        return sirID;
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 获得课程列表（老师）
     * @Date: 2018/1/26 22:48
     */
    public List<Course> getSirCourseList(HttpServletRequest request) {
        String sirID = getSirId(request);
        List<Course> courseList = courseService.selectClassBySirID(sirID);
        return courseList;
    }

    /**
     * -----------------------------------------------学生课堂------------------------------------
     **/
    /**
     * @Author: Jiang Jiahong
     * @Description: 获得学生加入班级列表
     * @Date: 2018/1/27 15:55
     */
    @PostMapping(value = "/getStuClass")
    public String getStuClass(HttpServletRequest request, Model model) {
        //1.获得登录学生的ID
        //2.再course表以及studentCourse表中联合查询 加入的班级
        List<StudentCourseInfo> studentCourseList = getStuCourseList(request);
        if (null != studentCourseList && 0 != studentCourseList.size()) {
            model.addAttribute("stuCourseList", studentCourseList);
        }
        return "student/stuClass";
    }

    @GetMapping(value = "/attendClass")
    public String attendClass() {
        return "student/joinClass";
    }

    @PostMapping(value = "/confirmAttendCourse")
    public String confirmAttendCourse(HttpServletRequest request, Model model) {
        //1. 获得输入的邀请码
        String invitationCode = request.getParameter("invitationCode");
        String tipInfo = "不可以重复加入相同班级";
        //2.判断邀请码的输入格式
        if (invitationCode.length() != 6) {
            tipInfo = "输入邀请码位数不正确";
            model.addAttribute("tipInfo", tipInfo);
            return "student/joinClass";
        } else {
            //3.查询是否有该课程   （course表）
            List<Course> coursesList = courseService.selectCourseByCode(invitationCode);
            if (null != coursesList && coursesList.size() > 0) {
                //3.1 获得该学生已经加入的班级  防止重复加入
                String stuID = getStuID(request);
                // （student-course 表）
                List<StudentCourseInfo> studentCourseList = getStuCourseList(request);

                //3.2 保留所有的courseID
                List<String> courseIdList = new ArrayList<>();
                for (Course course : coursesList) {
                    String preAttendCourseID = course.getCourseid();
                    courseIdList.add(preAttendCourseID);
                    for (StudentCourseInfo studentCourseInfo : studentCourseList) {
                        String hasAttendCourseID = studentCourseInfo.getCourseid();
                        //未去掉重复courseID
                        if (preAttendCourseID.equals(hasAttendCourseID)) {
                            courseIdList.remove(preAttendCourseID);
                            break;
                        }
                    }
                }

                //3.2 新建StudentCourse 对象
                String attendTime = Utils.getDate();
                for (int i = 0; i < courseIdList.size(); i++) {
                    String courseID = courseIdList.get(i);
                    StudentCourse studentCourse = new StudentCourse();
                    studentCourse.setStuid(stuID);
                    studentCourse.setAttendtime(attendTime);
                    studentCourse.setCourseid(courseID);
                    //3.3 插入到student_course 表
                    studentCourseService.insert(studentCourse);
                    tipInfo = "成功加入班级";

                }
            } else {
                tipInfo = "没有该邀请码";
                model.addAttribute("tipInfo", tipInfo);
                return "student/joinClass";
            }
        }
        model.addAttribute("tipInfo", tipInfo);
        return getStuClass(request, model);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 确认退出班级（学生）
     * @Date: 2018/1/28 12:24
     */
    @GetMapping("/confirmQuitCourse")
    public String confirmQuitCourse(HttpServletRequest request,Model model) {
        String courseId = request.getParameter("courseid");
        String stuId = getStuID(request);
        studentCourseService.deleteByStuIdAndCourseId(courseId,stuId);
        model.addAttribute("tipInfo","退出班级成功");
        return getStuClass(request, model);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 获得学生ID
     * @Date: 2018/1/27 17:46
     */
    public String getStuID(HttpServletRequest request) {
        //1.获得登录学生的ID
        Student student = (Student) request.getSession().getAttribute("user");
        String stuID = student.getStuid();
        return stuID;
    }
    /**
     * @Author: Jiang Jiahong
     * @Description: 获得所有学生加入的课程
     * @Date: 2018/1/28 12:28
     */
    public List<StudentCourseInfo> getStuCourseList(HttpServletRequest request){
        String stuID = getStuID(request);
        List<StudentCourseInfo> studentCourseList = studentCourseService.selectCourseList(stuID);
        return studentCourseList;
    }

}
