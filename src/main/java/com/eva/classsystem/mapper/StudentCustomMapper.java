package com.eva.classsystem.mapper;

import com.eva.classsystem.mapper.StudentMapper;
import com.eva.classsystem.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description: MapperCustom 是对Mapper的扩充
 * @Date: 2018/1/13 15:25
 */
@Component
public interface StudentCustomMapper extends StudentMapper {
    Student selectByStuID(String stuID);

    List<Student> selectAttendanceStu(List<String> stuIdList);

    List<Student> selectNotAttendanceStu(@Param("courseID") String courseID, @Param("attendanceID") int attendanceID);

}
