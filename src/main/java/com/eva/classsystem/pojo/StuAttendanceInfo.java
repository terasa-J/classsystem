package com.eva.classsystem.pojo;

import java.io.Serializable;

/**
 * @Author: Jiang Jiahong
 * @Description: 学生出勤的情况  结合 Student表 ，stu_attendance 表
 * @Date: 2018/1/30 20:44
 */
public class StuAttendanceInfo implements Serializable {

    private String name;

    private String stuid;

    private String calssno;

    private Integer stuattendid;

    private Integer attendanceid;

    private String location;

    public StuAttendanceInfo(String name, String stuid, String calssno, Integer stuattendid, Integer attendanceid, String location) {
        this.name = name;
        this.stuid = stuid;
        this.calssno = calssno;
        this.stuattendid = stuattendid;
        this.attendanceid = attendanceid;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getCalssno() {
        return calssno;
    }

    public void setCalssno(String calssno) {
        this.calssno = calssno;
    }

    public Integer getStuattendid() {
        return stuattendid;
    }

    public void setStuattendid(Integer stuattendid) {
        this.stuattendid = stuattendid;
    }

    public Integer getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(Integer attendanceid) {
        this.attendanceid = attendanceid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
