package com.eva.classsystem.service;

import com.eva.classsystem.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description:
 * @Date: 2018/2/3 22:32
 */
public interface NoticeService {
    List<Notice> selectBySir(@Param("sirID") String sirId, @Param("courseID") String courseId);

    int insert(Notice record);

    Notice selectByPrimaryKey(Integer noticeid);

    int deleteByPrimaryKey(Integer noticeid);

    int updateByPrimaryKey(Notice record);

    List <Notice> selectByStu(String courseId);
}
