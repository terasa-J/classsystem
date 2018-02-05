package com.eva.classsystem.service;

import com.eva.classsystem.pojo.Student;
import com.eva.classsystem.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description: 处理学生信息
 * @Date: 2018/1/13 15:22
 */
public interface StudentService {
    int insert(Student record);

    Student selectByStuID(String stuID);

    int updateByPrimaryKey(Student record);

    //签到的学生
    List<Student> selectAttendanceStu(List<String> stuIdList);

    //未签到的同学
    List<Student> selectNotAttendanceStu(@Param("courseID") String courseID, @Param("attendanceID") int attendanceID);

}
