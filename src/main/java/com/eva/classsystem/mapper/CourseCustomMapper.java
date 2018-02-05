package com.eva.classsystem.mapper;

import com.eva.classsystem.pojo.Course;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description: 课程
 * @Date: 2018/1/26 14:26
 */
@Component
public interface CourseCustomMapper extends CourseMapper {
    //获得全部班级信息
    List<Course> selectClassBySirID(String sirID);

    //查找某一班级
    Course selectByCourseID(String courseID);

    //删除班级
    int deleteByCourseID(String courseID);

    //根据邀请码获得班级 （邀请码不唯一）
    List<Course> selectCourseByCode(String code);

}
