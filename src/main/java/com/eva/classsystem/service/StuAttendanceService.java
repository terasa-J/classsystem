package com.eva.classsystem.service;

import com.eva.classsystem.pojo.CourseAttendanceInfo;
import com.eva.classsystem.pojo.StuAttendance;
import com.eva.classsystem.pojo.StuAttendanceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description:
 * @Date: 2018/1/30 13:50
 */
public interface StuAttendanceService {
    List<StuAttendanceInfo> selectAttendanceStu(int attendanceID);

    int insert(StuAttendance record);

    List<CourseAttendanceInfo> selectAttendance(@Param("stuID") String stuID, @Param("list")List<Integer> attendanceIdList);
}
