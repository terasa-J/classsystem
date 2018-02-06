package com.eva.classsystem.mapper;

import com.eva.classsystem.pojo.StudentCourse;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}