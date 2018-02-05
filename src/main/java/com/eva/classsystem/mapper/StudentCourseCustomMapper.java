package com.eva.classsystem.mapper;

import com.eva.classsystem.pojo.StudentCourse;
import com.eva.classsystem.pojo.StudentCourseInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentCourseCustomMapper extends StudentCourseMapper {
    //得到全部courseID
    List<StudentCourseInfo> selectCourseList(String stuID);

    //退出班级
    int deleteByStuIdAndCourseId(@Param("courseid") String courseID, @Param("stuid") String stuID);


}