package com.eva.classsystem.mapper;

import com.eva.classsystem.pojo.Attendance;

public interface AttendanceMapper {
    int deleteByPrimaryKey(Integer attendanceid);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Integer attendanceid);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
}