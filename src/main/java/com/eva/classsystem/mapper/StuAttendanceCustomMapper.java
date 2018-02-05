package com.eva.classsystem.mapper;

import com.eva.classsystem.pojo.CourseAttendanceInfo;
import com.eva.classsystem.pojo.StuAttendanceInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StuAttendanceCustomMapper extends StuAttendanceMapper {

    List<StuAttendanceInfo> selectAttendanceStu(int attendanceID);

    List<CourseAttendanceInfo> selectAttendance(@Param("stuID") String stuID, @Param("list")List<Integer> attendanceIdList);


}