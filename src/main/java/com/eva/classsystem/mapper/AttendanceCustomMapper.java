package com.eva.classsystem.mapper;

import com.eva.classsystem.pojo.Attendance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
public interface AttendanceCustomMapper extends AttendanceMapper {

    List<Attendance> selectAttendanceBySir(@Param("sirID") String sirID, @Param("courseID") String courseID);

    int deleteAttendanceBySirIdAndCourseId(@Param("sirID") String sirID, @Param("courseID") String courseID);

    int updateAttendanceBySirIdAndCourseId(@Param("sirID") String sirID, @Param("courseID") String courseID);

    List<Attendance> selectAttendanceByStu(@Param("sirID") String sirID,
                                           @Param("courseID") String courseID,
                                           @Param("attendanceCode") String attendanceCode);

    List<Attendance> selectTotalAttendance(@Param("sirID") String sirID,
                                           @Param("courseID") String courseID);

}