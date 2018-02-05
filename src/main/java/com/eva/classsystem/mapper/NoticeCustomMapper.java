package com.eva.classsystem.mapper;

import com.eva.classsystem.pojo.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface NoticeCustomMapper extends NoticeMapper{
    List <Notice> selectBySir(@Param("sirID") String sirId, @Param("courseID") String courseId);

    List <Notice> selectByStu(String courseId);
}