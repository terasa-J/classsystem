package com.eva.classsystem.service;

import com.eva.classsystem.pojo.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description:
 * @Date: 2018/1/29 17:18
 */
public interface AttendanceService {
    List<Attendance> selectAttendanceBySir(@Param("sirID") String sirID, @Param("courseID") String courseID);

    int insert(Attendance record);

    Attendance selectByPrimaryKey(Integer attendanceid);

    int updateByPrimaryKey(Attendance record);

    int deleteByPrimaryKey(Integer attendanceid);

    int deleteAttendanceBySirIdAndCourseId(@Param("sirID") String sirID, @Param("courseID") String courseID);

    int updateAttendanceBySirIdAndCourseId(@Param("sirID") String sirID, @Param("courseID") String courseID);

    List<Attendance> selectAttendanceByStu(@Param("sirID") String sirID,
                                           @Param("courseID") String courseID,
                                           @Param("attendanceCode") String attendanceCode);

    List<Attendance> selectTotalAttendance(@Param("sirID") String sirID,
                                           @Param("courseID") String courseID);

}
