package com.eva.classsystem.service;

import com.eva.classsystem.pojo.Teacher;

/**
 * @Author: Jiang Jiahong
 * @Description:
 * @Date: 2018/1/13 16:33
 */
public interface TeacherService {
    int insert(Teacher record);

    Teacher selectBySirID(String sirID);

    int updateByPrimaryKey(Teacher record);
}
