package com.eva.classsystem.service;

import com.eva.classsystem.mapper.NoticeCustomMapper;
import com.eva.classsystem.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Jiang Jiahong
 * @Description:
 * @Date: 2018/2/3 22:32
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeCustomMapper noticeCustomMapper;
    @Override
    public List<Notice> selectBySir(String sirId, String courseId) {
        return noticeCustomMapper.selectBySir(sirId,courseId);
    }

    @Override
    public int insert(Notice record) {
        return noticeCustomMapper.insert(record);
    }

    @Override
    public Notice selectByPrimaryKey(Integer noticeid) {
        return noticeCustomMapper.selectByPrimaryKey(noticeid);
    }

    @Override
    public int deleteByPrimaryKey(Integer noticeid) {
        return noticeCustomMapper.deleteByPrimaryKey(noticeid);
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return noticeCustomMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Notice> selectByStu(String courseId) {
        return noticeCustomMapper.selectByStu(courseId);
    }
}
