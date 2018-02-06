package com.eva.classsystem.pojo;

import java.io.Serializable;

public class StuAttendance implements Serializable {
    private Integer stuattendid;

    private String stuid;

    private Integer attendanceid;

    private String attendancecode;

    private String location;

    private String attendtime;

    private static final long serialVersionUID = 1L;

    public StuAttendance(Integer stuattendid, String stuid, Integer attendanceid, String attendancecode, String location, String attendtime) {
        this.stuattendid = stuattendid;
        this.stuid = stuid;
        this.attendanceid = attendanceid;
        this.attendancecode = attendancecode;
        this.location = location;
        this.attendtime = attendtime;
    }

    public StuAttendance() {
        super();
    }

    public Integer getStuattendid() {
        return stuattendid;
    }

    public void setStuattendid(Integer stuattendid) {
        this.stuattendid = stuattendid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public Integer getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(Integer attendanceid) {
        this.attendanceid = attendanceid;
    }

    public String getAttendancecode() {
        return attendancecode;
    }

    public void setAttendancecode(String attendancecode) {
        this.attendancecode = attendancecode == null ? null : attendancecode.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
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
        StuAttendance other = (StuAttendance) that;
        return (this.getStuattendid() == null ? other.getStuattendid() == null : this.getStuattendid().equals(other.getStuattendid()))
            && (this.getStuid() == null ? other.getStuid() == null : this.getStuid().equals(other.getStuid()))
            && (this.getAttendanceid() == null ? other.getAttendanceid() == null : this.getAttendanceid().equals(other.getAttendanceid()))
            && (this.getAttendancecode() == null ? other.getAttendancecode() == null : this.getAttendancecode().equals(other.getAttendancecode()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getAttendtime() == null ? other.getAttendtime() == null : this.getAttendtime().equals(other.getAttendtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuattendid() == null) ? 0 : getStuattendid().hashCode());
        result = prime * result + ((getStuid() == null) ? 0 : getStuid().hashCode());
        result = prime * result + ((getAttendanceid() == null) ? 0 : getAttendanceid().hashCode());
        result = prime * result + ((getAttendancecode() == null) ? 0 : getAttendancecode().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getAttendtime() == null) ? 0 : getAttendtime().hashCode());
        return result;
    }
}