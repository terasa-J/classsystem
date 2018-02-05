package com.eva.classsystem.pojo;

import java.io.Serializable;

/**
 * @Author: Jiang Jiahong
 * @Description:
 * @Date: 2018/2/1 14:59
 */
public class CourseAttendanceInfo implements Serializable {
    private Integer attendanceid;
    private String sirid;
    private String name;
    private String courseid;
    private String stuid;
    private String location;
    private String attendtime;

    public CourseAttendanceInfo(Integer attendanceid, String sirid, String name, String courseid, String stuid, String location, String attendtime) {
        this.attendanceid = attendanceid;
        this.sirid = sirid;
        this.name = name;
        this.courseid = courseid;
        this.stuid = stuid;
        this.location = location;
        this.attendtime = attendtime;
    }

    public Integer getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(int attendanceid) {
        this.attendanceid = attendanceid;
    }

    public String getSirid() {
        return sirid;
    }

    public void setSirid(String sirid) {
        this.sirid = sirid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAttendtime() {
        return attendtime;
    }

    public void setAttendtime(String attendtime) {
        this.attendtime = attendtime;
    }
}
