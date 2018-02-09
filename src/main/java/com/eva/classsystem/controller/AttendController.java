package com.eva.classsystem.controller;

import com.eva.classsystem.pojo.*;
import com.eva.classsystem.service.AttendanceServiceImpl;
import com.eva.classsystem.service.StuAttendanceServiceImpl;
import com.eva.classsystem.service.StudentServiceImpl;
import com.eva.classsystem.utils.Utils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import static com.eva.classsystem.utils.Utils.createExcel;

/**
 * @Author: Jiang Jiahong
 * @Description:
 * @Date: 2018/1/27 12:25
 */
@Controller
public class AttendController {
    @Autowired
    CourseController courseController;
    @Autowired
    AttendanceServiceImpl attendanceService;
    @Autowired
    StuAttendanceServiceImpl stuAttendanceService;
    @Autowired
    StudentServiceImpl studentService;


    /**
     * @Author: Jiang Jiahong
     * @Description: 考勤列表
     * @Date: 2018/1/29 18:51
     */
    @GetMapping(value = "/sirAttend")
    public String sirAttend(HttpServletRequest request, Model model) {
      // 在教师公告 返回 课堂考勤需要
        String  index = request.getParameter("index");
        model.addAttribute("index", index);
        request.getSession().setAttribute("index",index);

        //保存点击进去班级详细信息
        Course course = courseController.getCourseByStatusIndex(request,index);
        String courseID = course.getCourseid();
        //查询该课程考勤列表
        List<Attendance> attendanceList = getAttendanceList(request, courseID);
        //保存点击进去班级详细信息
        request.getSession().setAttribute("sirCourse", course);
        model.addAttribute("course", course);
        model.addAttribute("attendanceList", attendanceList);
        return "teacher/attend/sirAttend";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 主页面 点击 创建考勤
     * @Date: 2018/1/29 18:51
     */
    @GetMapping(value = "/createAttendance")
    public String createAttendance(HttpServletRequest request, Model model) {
        String courseId = request.getParameter("courseId");
        String name = request.getParameter("name");
        model.addAttribute("courseId", courseId);
        model.addAttribute("name", name);
        return "teacher/attend/createAttendance";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 点击 确认创建考勤
     * @Date: 2018/1/29 18:51
     */
    @PostMapping(value = "/confirmCreateAttendance")
    public String confirmCreateAttendance(HttpServletRequest request, Model model) {
        //1.初始化信息
        String courseId = request.getParameter("courseId");
        String sirId = courseController.getSirId(request);
        String name = request.getParameter("name");
        String actualNumber = request.getParameter("actualNumber");
        String attendanceCode = Utils.getAttendanceCode();
        String createTime = Utils.getDate();
        //2.新建对象
        Attendance attendance = new Attendance();
        attendance.setCourseid(courseId);
        attendance.setSirid(sirId);
        attendance.setAttendancecode(attendanceCode);
        attendance.setActualnumber(Integer.parseInt(actualNumber));
        attendance.setName(name);
        attendance.setCreatetime(createTime);
        //3.新建数据
        attendanceService.insert(attendance);


        List<String> listCode = new ArrayList<>();
        for (int i = 0; i < attendanceCode.length(); i++) {
            listCode.add(attendanceCode.substring(i, i + 1));
        }
        //本页面需要
        model.addAttribute("listCode", listCode);
        model.addAttribute("name", name);
        //隐藏给下一个页面  结束考勤按钮
        model.addAttribute("courseId", courseId);
        model.addAttribute("sirId", sirId);

        return "teacher/attend/beginAttendance";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 点击 放弃考勤
     * @Date: 2018/1/29 18:51
     */
    @PostMapping(value = "/confirmDropAttendance")
    public String confirmDropAttendance(HttpServletRequest request, Model model) {
        //删除考勤
        String courseId = request.getParameter("courseId");
        String sirId = request.getParameter("sirId");
        attendanceService.deleteAttendanceBySirIdAndCourseId(sirId, courseId);

        Course course = (Course) request.getSession().getAttribute("sirCourse");
        model.addAttribute("course", course);
        //查询该课程考勤列表
        List<Attendance> attendanceList = getAttendanceList(request, course.getCourseid());
        //保存点击进去班级详细信息
        model.addAttribute("attendanceList", attendanceList);
        return "teacher/attend/sirAttend";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 结束考勤   删除签到码
     * @Date: 2018/1/29 18:33
     */
    @PostMapping(value = "/endAttendance")
    public String endAttendance(HttpServletRequest request, Model model) {
        //1.获得信息
        String courseId = request.getParameter("courseId");
        String sirId = request.getParameter("sirId");
        //2.设置考勤码为空
        attendanceService.updateAttendanceBySirIdAndCourseId(sirId, courseId);

        return confirmDropAttendance(request, model);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 点击查看考勤详情
     * @Date: 2018/1/30 13:35
     */
    @GetMapping(value = "/attendanceDetail")
    public String attendanceDetail(HttpServletRequest request, Model model, boolean isExport) {
        String attendanceId = request.getParameter("attendanceId");
        String courseId = request.getParameter("courseId");
        model.addAttribute("courseId", courseId);
        int attendanceID = Integer.parseInt(attendanceId);
        //获得点击的考勤信息
        Attendance attendance = attendanceService.selectByPrimaryKey(attendanceID);
        //应到人数
        int actualNum = attendance.getActualnumber();
        model.addAttribute("attendance", attendance);
        //参与考勤的学生   (改 sql 语句)  自己新建一个对象
        List<StuAttendanceInfo> stuAttendanceList = stuAttendanceService.selectAttendanceStu(attendanceID);
        //实到人数
        int attendanceNum = stuAttendanceList.size();
        model.addAttribute("attendanceNum", attendanceNum);
        //缺勤人数
        int restNum = Math.abs(actualNum - attendanceNum);
        model.addAttribute("restNum", restNum);
        //得到全部签到的stuID  ( 当有人签到了才查询 )
        if (null != stuAttendanceList && stuAttendanceList.size() > 0) {
            model.addAttribute("stuAttendanceList", stuAttendanceList);
        }
        // 未签到的同学
        List<Student> notAttendStuList = studentService.selectNotAttendanceStu(courseId, attendanceID);
        if (null != notAttendStuList && notAttendStuList.size() > 0) {
            model.addAttribute("notAttendStuList", notAttendStuList);
        }

        //点击导出邮箱使用
        if (isExport == true) {
            Teacher teacher = (Teacher) request.getSession().getAttribute("user");
            String toUser = teacher.getEmail();
            //获取各个学生的 GPS 定位情况
            createExcel(attendance, stuAttendanceList, notAttendStuList, toUser);
            System.out.println("export to Email");
        }
        return "teacher/attend/attendanceDetail";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 点击 编辑考勤姓名
     * @Date: 2018/1/30 16:26
     */
    @GetMapping(value = "/updateAttendance")
    public String updateAttendance(HttpServletRequest request, Model model) {
        String attendanceId = request.getParameter("attendanceId");
        String attendanceName = request.getParameter("attendanceName");
        model.addAttribute("attendanceId", attendanceId);
        model.addAttribute("attendanceName", attendanceName);
        return "teacher/attend/updateAttendance";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 点击 确认修改名称
     * @Date: 2018/1/30 16:34
     */
    @PostMapping(value = "/confirmUpdateAttendance")
    public String confirmUpdateAttendance(HttpServletRequest request, Model model) {
        String attendanceName = request.getParameter("attendanceName");
        String attendanceId = request.getParameter("attendanceId");
        Attendance attendance = attendanceService.selectByPrimaryKey(Integer.parseInt(attendanceId));
        attendance.setName(attendanceName);
        int num = attendanceService.updateByPrimaryKey(attendance);
        if (num > 0) {
            model.addAttribute("tipInfo", "重命名成功");
        } else {
            model.addAttribute("tipInfo", "重命名失败");
        }
        return confirmDropAttendance(request, model);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 点击删除考勤
     * @Date: 2018/1/30 16:58
     */
    @GetMapping(value = "/confirmDelAttend")
    public String confirmDelAttend(HttpServletRequest request, Model model) {
        String attendanceId = request.getParameter("attendanceId");
        System.out.println("-------attendanceId----------"+attendanceId);
        int result = attendanceService.deleteByPrimaryKey(Integer.parseInt(attendanceId));
        if (result > 0) {
            model.addAttribute("tipInfo", "删除考勤成功");
        } else {
            model.addAttribute("tipInfo", "删除考勤失败");
        }
        return confirmDropAttendance(request, model);
    }

    @GetMapping(value = "/exportEmail")
    public String exportEmail(HttpServletRequest request, Model model) {
        model.addAttribute("tipInfo", "已导出，详请前往邮箱查看");
        return attendanceDetail(request, model, true);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 获得老师考勤表
     * @Date: 2018/1/29 17:36
     */
    public List<Attendance> getAttendanceList(HttpServletRequest request, String courseID) {
        String sirID = courseController.getSirId(request);
        //查询该课程考勤列表
        List<Attendance> attendanceList = attendanceService.selectAttendanceBySir(sirID, courseID);
        return attendanceList;
    }


    /**
     * ---------------------------------------------------学生签到-----------------------------------------------
     **/

    /**
     * @Author: Jiang Jiahong
     * @Description: 学生考勤 主页面
     * @Date: 2018/1/31 13:53
     */
    @PostMapping(value = "/stuAttend")
    public String stuAttend(HttpServletRequest request, Model model) {
        String index = request.getParameter("index");
        //保留给下一个页面
        model.addAttribute("index", index);
        int stuCourseIndex = Integer.parseInt(index);
        List<StudentCourseInfo> studentCourseInfoList = courseController.getStuCourseList(request);
        StudentCourseInfo studentCourseInfo = studentCourseInfoList.get(stuCourseIndex);
        model.addAttribute("studentCourseInfo", studentCourseInfo);
        //显示 学生在该门课程考勤的情况
        String sirId = studentCourseInfo.getSirid();
        String courseId = studentCourseInfo.getCourseid();
        //1.查询该课程一共进行几次考勤，并获得attendanceId
        List<Attendance> attendanceList = attendanceService.selectTotalAttendance(sirId, courseId);
        int totalNum = attendanceList.size();
        String stuId = courseController.getStuID(request);
        if (totalNum > 0) {
            model.addAttribute("totalNum", totalNum);
            //所以考勤的ID
            List<Integer> totalAttendanceIdList = new ArrayList<>();
            for (Attendance attendance : attendanceList) {
                totalAttendanceIdList.add(attendance.getAttendanceid());
            }
            //  出勤了老师考勤情况
            List<CourseAttendanceInfo> courseAttendanceInfoList = stuAttendanceService.selectAttendance(stuId, totalAttendanceIdList);
            model.addAttribute("courseAttendanceInfoList", courseAttendanceInfoList);
            int attendNum = courseAttendanceInfoList.size();
            model.addAttribute("attendNum", attendNum);
            int notAttendNum = Math.abs(totalNum - attendNum);
            model.addAttribute("notAttendNum", notAttendNum);
            // 参加考勤的ID
            List<Integer> attendIdList = new ArrayList<>();
            for (CourseAttendanceInfo courseAttendanceInfo : courseAttendanceInfoList) {
                attendIdList.add(courseAttendanceInfo.getAttendanceid());
            }
            //缺勤的情况  获得未考勤的ID
            List<Integer> notAttendIdList = new ArrayList<>();
            boolean isAttend = true;
            for (int i = 0; i < totalNum; i++) {
                for (int j = 0; j < attendNum; j++) {
                    if (!totalAttendanceIdList.get(i).equals(attendIdList.get(j))) {
                        isAttend = false;
                    }else{
                        isAttend = true;
                        break;
                    }
                }
                if (isAttend == false) {
                    notAttendIdList.add(i);
                }
            }
            //缺勤的List
            List<Attendance> notAttendanceList = new ArrayList<>();
            for (int i = 0; i < notAttendIdList.size(); i++) {
                notAttendanceList.add(attendanceList.get(notAttendIdList.get(i)));
            }
            model.addAttribute("notAttendanceList", notAttendanceList);
        } else {
            //没有考勤情况
            model.addAttribute("totalNum", "0");
            model.addAttribute("attendNum", "0");
            model.addAttribute("notAttendNum", "0");
        }

        return "student/attend/stuAttend";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 数字签到界面
     * @Date: 2018/1/31 15:37
     */
    @GetMapping(value = "/gotoNumberAttendance")
    public String gotoNumberAttendance(HttpServletRequest request, Model model) {
        String sirId = request.getParameter("sirId");
        String courseId = request.getParameter("courseId");
        //隐藏
        String index = request.getParameter("index");
        model.addAttribute("sirId", sirId);
        model.addAttribute("courseId", courseId);
        model.addAttribute("index", index);
        model.addAttribute("tipInfo", "请输入签到码");
        return "student/attend/numberAttend";
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: GPS定位签到
     * @Date: 2018/1/31 15:38
     */
    @PostMapping(value = "/gotoWebAttendance")
    public String gotoWebAttendance(HttpServletRequest request, Model model) {
        //隐藏
        String index = request.getParameter("index");
        String sirId = request.getParameter("sirId");
        String courseId = request.getParameter("courseId");
        String attendanceCode = request.getParameter("attendanceCode");
        //判断是否存在该考勤信息
        List<Attendance> attendanceList = attendanceService.selectAttendanceByStu(sirId, courseId, attendanceCode);
        if (attendanceList.size() == 1) {
            Attendance attendance = attendanceList.get(0);
            int attendanceId = attendance.getAttendanceid();
            model.addAttribute("attendanceId", attendanceId);//隐藏
            model.addAttribute("attendanceCode", attendanceCode);//隐藏
            model.addAttribute("index", index); //隐藏
            return "student/attend/webAttend";
        } else {
            model.addAttribute("tipInfo", "数字签到数字有误");
            return "student/attend/numberAttend";
        }

    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 点击 确认签到
     * @Date: 2018/2/1 11:21
     */
    @PostMapping(value = "/confirmAttend")
    public String confirmAttend(HttpServletRequest request, Model model) {
        //1.获取基本信息
        String location = request.getParameter("location");
        //jsp中是中文的：  不是英文的:
        String[] str = location.split("：");
        String address = str[1];
        System.out.println("----address----"+address);
        System.out.println("----str----"+str[0]);
        System.out.println("----str----"+str[1]);

        if(address.startsWith("FAILED")||address.startsWith("NOT_SUPPORTED")){
            model.addAttribute("tipInfo", "获取定位失败,无法签到");
            return "student/attend/webAttend";
        }
        String stuId = courseController.getStuID(request);
        String attendanceId = request.getParameter("attendanceId");
        String attendanceCode = request.getParameter("attendanceCode");
        String attendTime = Utils.getDate();
        //2.新建对象
        StuAttendance stuAttendance = new StuAttendance();
        stuAttendance.setAttendancecode(attendanceCode);
        stuAttendance.setAttendanceid(Integer.parseInt(attendanceId));
        stuAttendance.setLocation(address);
        stuAttendance.setStuid(stuId);
        stuAttendance.setAttendtime(attendTime);
        //3.插入数据
        int num = stuAttendanceService.insert(stuAttendance);
        if (num > 0) {
            model.addAttribute("tipInfo", "考勤成功");
        } else {
            model.addAttribute("tipInfo", "考勤失败");
        }
        //等老师结束考勤后数据才更新
        return stuAttend(request, model);
    }

}
