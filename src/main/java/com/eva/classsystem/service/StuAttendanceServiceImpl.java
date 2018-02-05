package com.eva.classsystem.service;

import com.eva.classsystem.mapper.StuAttendanceCustomMapper;
import com.eva.classsystem.pojo.CourseAttendanceInfo;
import com.eva.classsystem.pojo.StuAttendance;
import com.eva.classsystem.pojo.StuAttendanceInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description:
 * @Date: 2018/1/30 13:50
 */
@Service
public class StuAttendanceServiceImpl implements StuAttendanceService {
    @Autowired
    StuAttendanceCustomMapper stuAttendanceCustomMapper;

    @Override
    public List<StuAttendanceInfo> selectAttendanceStu(int attendanceID) {
        return stuAttendanceCustomMapper.selectAttendanceStu(attendanceID);
    }

    @Override
    public int insert(StuAttendance record) {
        return stuAttendanceCustomMapper.insert(record);
    }

    @Override
    public List<CourseAttendanceInfo> selectAttendance(@Param("stuID") String stuID, @Param("list")List<Integer> attendanceIdList) {
        return stuAttendanceCustomMapper.selectAttendance(stuID,attendanceIdList);
    }
}
