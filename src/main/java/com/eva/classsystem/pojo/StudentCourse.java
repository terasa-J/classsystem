package com.eva.classsystem.pojo;

import java.io.Serializable;

public class StudentCourse implements Serializable {
    private Integer id;

    private String courseid;

    private String stuid;

    private String attendtime;

    private static final long serialVersionUID = 1L;

    public StudentCourse(Integer id, String courseid, String stuid, String attendtime) {
        this.id = id;
        this.courseid = courseid;
        this.stuid = stuid;
        this.attendtime = attendtime;
    }

    public StudentCourse() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid == null ? null : courseid.trim();
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public String getAttendtime() {
        return attendtime;
    }

    public void setAttendtime(String attendtime) {
        this.attendtime = attendtime == null ? null : attendtime.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        StudentCourse other = (StudentCourse) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCourseid() == null ? other.getCourseid() == null : this.getCourseid().equals(other.getCourseid()))
            && (this.getStuid() == null ? other.getStuid() == null : this.getStuid().equals(other.getStuid()))
            && (this.getAttendtime() == null ? other.getAttendtime() == null : this.getAttendtime().equals(other.getAttendtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCourseid() == null) ? 0 : getCourseid().hashCode());
        result = prime * result + ((getStuid() == null) ? 0 : getStuid().hashCode());
        result = prime * result + ((getAttendtime() == null) ? 0 : getAttendtime().hashCode());
        return result;
    }
}