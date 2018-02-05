package com.eva.classsystem.service;

import com.eva.classsystem.mapper.AttendanceCustomMapper;
import com.eva.classsystem.pojo.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description: 签到 业务处理
 * @Date: 2018/1/29 17:19
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceCustomMapper attendanceCustomMapper;
    @Override
    public List<Attendance> selectAttendanceBySir(String sirID, String courseID) {
        return attendanceCustomMapper.selectAttendanceBySir(sirID,courseID);
    }

    @Override
    public int insert(Attendance record) {
        return attendanceCustomMapper.insert(record);
    }

    @Override
    public Attendance selectByPrimaryKey(Integer attendanceid) {
        return attendanceCustomMapper.selectByPrimaryKey(attendanceid);
    }

    @Override
    public int updateByPrimaryKey(Attendance record) {
        return attendanceCustomMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer attendanceid) {
        return attendanceCustomMapper.deleteByPrimaryKey(attendanceid);
    }

    @Override
    public int deleteAttendanceBySirIdAndCourseId(String sirID, String courseID) {
        return attendanceCustomMapper.deleteAttendanceBySirIdAndCourseId(sirID,courseID);
    }

    @Override
    public int updateAttendanceBySirIdAndCourseId(String sirID, String courseID) {
        return attendanceCustomMapper.updateAttendanceBySirIdAndCourseId(sirID,courseID);
    }

    @Override
    public List<Attendance> selectAttendanceByStu(String sirID, String courseID, String attendanceCode) {
        return attendanceCustomMapper.selectAttendanceByStu(sirID, courseID, attendanceCode);
    }

    @Override
    public List<Attendance> selectTotalAttendance(String sirID, String courseID) {
        return attendanceCustomMapper.selectTotalAttendance(sirID,courseID);
    }
}
