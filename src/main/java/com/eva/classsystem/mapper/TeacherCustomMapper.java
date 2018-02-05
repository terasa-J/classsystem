package com.eva.classsystem.mapper;

import com.eva.classsystem.pojo.Teacher;
import org.springframework.stereotype.Component;

/**
 * @Author: Jiang Jiahong
 * @Description: 教师端业务
 * @Date: 2018/1/13 16:32
 */
@Component
public interface TeacherCustomMapper extends TeacherMapper{
    Teacher selectBySirID(String sirID);
}
