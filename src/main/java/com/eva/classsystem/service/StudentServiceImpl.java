package com.eva.classsystem.service;

import com.eva.classsystem.mapper.StudentCustomMapper;
import com.eva.classsystem.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description: 处理学生业务的具体实现
 * @Date: 2018/1/13 15:23
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentCustomMapper studentMapperCustom;

    @Override
    public int insert(Student record) {
        return studentMapperCustom.insert(record);
    }

    @Override
    public Student selectByStuID(String stuID) {
        return studentMapperCustom.selectByStuID(stuID);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapperCustom.updateByPrimaryKey(record);
    }

    @Override
    public List<Student> selectAttendanceStu(List<String> stuIdList) {
        return studentMapperCustom.selectAttendanceStu(stuIdList);
    }

    @Override
    public List<Student> selectNotAttendanceStu(String courseID, int attendanceID) {
        return studentMapperCustom.selectNotAttendanceStu(courseID,attendanceID);
    }


}
