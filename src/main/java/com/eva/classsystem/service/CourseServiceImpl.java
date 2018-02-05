package com.eva.classsystem.service;

import com.eva.classsystem.mapper.CourseCustomMapper;
import com.eva.classsystem.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description: 课程
 * @Date: 2018/1/26 14:28
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseCustomMapper courseCustomMapper;

    /**
     * @Author: Jiang Jiahong
     * @Description: 创建班级
     * @Date: 2018/1/26 14:28
     */
    @Override
    public int insert(Course record) {
        return courseCustomMapper.insert(record);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 获得全部班级
     * @Date: 2018/1/26 14:45
     */
    @Override
    public List<Course> selectClassBySirID(String sirID) {
        return courseCustomMapper.selectClassBySirID(sirID);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 获得某一班级
     * @Date: 2018/1/26 16:44
     */
    @Override
    public Course selectByCourseID(String courseID) {
        return courseCustomMapper.selectByCourseID(courseID);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 班级班级
     * @Date: 2018/1/26 16:44
     */
    @Override
    public int updateByPrimaryKey(Course record) {
        return courseCustomMapper.updateByPrimaryKey(record);
    }

    /**
     * @Author: Jiang Jiahong
     * @Description: 删除班级
     * @Date: 2018/1/26 16:44
     */

    @Override
    public int deleteByCourseID(String courseID) {
        return courseCustomMapper.deleteByCourseID(courseID);
    }

    @Override
    public List<Course> selectCourseByCode(String code) {
        return courseCustomMapper.selectCourseByCode(code);
    }


}
