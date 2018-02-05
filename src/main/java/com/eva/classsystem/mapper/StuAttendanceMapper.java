package com.eva.classsystem.mapper;

import com.eva.classsystem.pojo.StuAttendance;

public interface StuAttendanceMapper {
    int deleteByPrimaryKey(Integer stuattendid);

    int insert(StuAttendance record);

    int insertSelective(StuAttendance record);

    StuAttendance selectByPrimaryKey(Integer stuattendid);

    int updateByPrimaryKeySelective(StuAttendance record);

    int updateByPrimaryKey(StuAttendance record);
}