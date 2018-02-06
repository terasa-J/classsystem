package com.eva.classsystem.controller;

import com.eva.classsystem.pojo.Course;
import com.eva.classsystem.pojo.Notice;
import com.eva.classsystem.pojo.Teacher;
import com.eva.classsystem.service.CourseServiceImpl;
import com.eva.classsystem.service.NoticeServiceImpl;
import com.eva.classsystem.service.TeacherServiceImpl;
import com.eva.classsystem.utils.RoleUtills;
import com.eva.classsystem.utils.Utils;
import javafx.beans.property.IntegerProperty;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description: 教师公告
 * @Date: 2018/2/3 21:37
 */
@Controller
public class NoticeController {
    @Autowired
    CourseController courseController;
    @Autowired
    NoticeServiceImpl noticeService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    CourseServiceImpl courseService;

    /**
     * @Author: Jiang Jiahong
     * @Description: 老师 公告界面
     * @Date: 2018/2/3 22:25
     */
    @GetMapping(value = "/noticePage")
    public String noticePage(HttpServletRequest request, Model model) {
        //返回 课堂考勤页面
        String index = request.getParameter("index");
        model.addAttribute("index", index);

        String courseId = request.getParameter("courseid");
        Course course = courseController.getCourseByCourseID(request);
        String sirId = courseController.getSirId(request);
        List<Notice> noticeList = noticeService.selectBySir(sirId, courseId);
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("courseId", courseId);
        model.addAttribute("sirId", sirId);
        model.addAttribute("course", course);
        return "notice/notice";
    }

    @GetMapping(value = "/createNoticePage")
    public String createNoticePage(HttpServletRequest request, Model model) {
        //返回 课堂考勤页面
        String index = request.getParameter("index");
        model.addAttribute("index", index);

        String courseId = request.getParameter("courseId");
        String sirId = request.getParameter("sirId");
        model.addAttribute("courseId", courseId);
        model.addAttribute("sirId", sirId);
        return "notice/createNotice";
    }

    @PostMapping(value = "/confirmCreateNotice")
    public String confirmCreateNotice(HttpServletRequest request, Model model) {
        String courseId = request.getParameter("courseid");
        String sirId = request.getParameter("sirId");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String createTime = Utils.getDate();
        Notice notice = new Notice();
        notice.setContent(content);
        notice.setCourseid(courseId);
        notice.setSirid(sirId);
        notice.setTitle(title);
        notice.setCreatetime(createTime);
        int res = noticeService.insert(notice);
        if (res > 0) {
            model.addAttribute("tipInfo", "发布通告成功");
        } else {
            model.addAttribute("tipInfo", "发布通告失败");
        }
        return noticePage(request, model);
    }

    @GetMapping(value = "/updateNotice")
    public String updateNotice(HttpServletRequest request, Model model) {
        String noticeId = request.getParameter("noticeid");
        String courseId = request.getParameter("courseid");
        //返回 课堂考勤页面
        String index = request.getParameter("index");
        model.addAttribute("index", index);

        Notice notice = noticeService.selectByPrimaryKey(Integer.parseInt(noticeId));
        model.addAttribute("notice", notice);
        model.addAttribute("courseId", courseId);
        return "notice/updateNotice";
    }

    @PostMapping(value = "/confirmUpdateNotice")
    public String confirmUpdateNotice(HttpServletRequest request, Model model) {
        String noticeId = request.getParameter("noticeid");
        Notice notice = noticeService.selectByPrimaryKey(Integer.parseInt(noticeId));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String createTime = Utils.getDate();
        notice.setTitle(title);
        notice.setContent(content);
        notice.setCreatetime(createTime);
        int res = noticeService.updateByPrimaryKey(notice);
        if (res > 0) {
            model.addAttribute("tipInfo", "更新通告成功");
        } else {
            model.addAttribute("tipInfo", "更新通告失败");
        }
        return noticePage(request, model);
    }

    @GetMapping(value = "/confirmDeleteNotice")
    public String confirmDeleteNotice(HttpServletRequest request, Model model) {
        String noticeId = request.getParameter("noticeid");
        int res = noticeService.deleteByPrimaryKey(Integer.parseInt(noticeId));
        if (res > 0) {
            model.addAttribute("tipInfo", "删除通告成功");
        } else {
            model.addAttribute("tipInfo", "删除通告失败");
        }
        return noticePage(request, model);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 公告详情  （老师 学生 公用）
     * @Date: 2018/2/5 11:10
     */
    @GetMapping(value = "/noticeDetail")
    public String noticeDetail(HttpServletRequest request, Model model) {
        String noticeId = request.getParameter("noticeId");
        Notice notice = noticeService.selectByPrimaryKey(Integer.parseInt(noticeId));
        model.addAttribute("notice", notice);
        String sirId = notice.getSirid();
        Teacher teacher = teacherService.selectBySirID(sirId);
        model.addAttribute("teacher", teacher);
        return "notice/noticeDetail";
    }

    /**
     * ----------------------------------学生角色-------------------------------------
     **/
    @GetMapping(value = "/stuNoticePage")
    public String stuNoticePage(HttpServletRequest request, Model model) {
        //返回 课堂考勤页面
        //返回 课堂考勤页面
        String index = request.getParameter("index");
        model.addAttribute("index", index);

        String courseId = request.getParameter("courseId");
        List<Notice> noticeList = noticeService.selectByStu(courseId);
        model.addAttribute("noticeList", noticeList);
        Course course = courseService.selectByCourseID(courseId);
        model.addAttribute("course", course);
        return "notice/stuNotice";
    }


}
