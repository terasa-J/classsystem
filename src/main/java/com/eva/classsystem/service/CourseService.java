package com.eva.classsystem.service;

import com.eva.classsystem.pojo.Course;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description:
 * @Date: 2018/1/26 14:27
 */
public interface CourseService {
    int insert(Course record);

    List<Course> selectClassBySirID(String sirID);

    Course selectByCourseID(String courseID);

    int updateByPrimaryKey(Course record);

    int deleteByCourseID(String courseID);

    List<Course> selectCourseByCode(String code);

}
