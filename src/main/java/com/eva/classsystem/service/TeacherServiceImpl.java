package com.eva.classsystem.service;

import com.eva.classsystem.mapper.TeacherCustomMapper;
import com.eva.classsystem.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Jiang Jiahong
 * @Description: 教师业务具体处理
 * @Date: 2018/1/13 16:33
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherCustomMapper teacherMapperCustom;

    @Override
    public int insert(Teacher record) {
        return teacherMapperCustom.insert(record);
    }

    @Override
    public Teacher selectBySirID(String sirID) {
        return teacherMapperCustom.selectBySirID(sirID);
    }

    @Override
    public int updateByPrimaryKey(Teacher record) {
        return teacherMapperCustom.updateByPrimaryKey(record);
    }


}
