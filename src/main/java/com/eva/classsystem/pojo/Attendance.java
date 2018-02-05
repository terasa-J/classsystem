package com.eva.classsystem.pojo;

import java.io.Serializable;

public class Attendance implements Serializable {
    private Integer attendanceid;

    private String sirid;

    private String createtime;

    private String name;

    private Integer actualnumber;

    private String attendancecode;

    private String courseid;

    private static final long serialVersionUID = 1L;

    public Attendance(Integer attendanceid, String sirid, String createtime, String name, Integer actualnumber, String attendancecode, String courseid) {
        this.attendanceid = attendanceid;
        this.sirid = sirid;
        this.createtime = createtime;
        this.name = name;
        this.actualnumber = actualnumber;
        this.attendancecode = attendancecode;
        this.courseid = courseid;
    }

    public Attendance() {
        super();
    }

    public Integer getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(Integer attendanceid) {
        this.attendanceid = attendanceid;
    }

    public String getSirid() {
        return sirid;
    }

    public void setSirid(String sirid) {
        this.sirid = sirid == null ? null : sirid.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getActualnumber() {
        return actualnumber;
    }

    public void setActualnumber(Integer actualnumber) {
        this.actualnumber = actualnumber;
    }

    public String getAttendancecode() {
        return attendancecode;
    }

    public void setAttendancecode(String attendancecode) {
        this.attendancecode = attendancecode == null ? null : attendancecode.trim();
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid == null ? null : courseid.trim();
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
        Attendance other = (Attendance) that;
        return (this.getAttendanceid() == null ? other.getAttendanceid() == null : this.getAttendanceid().equals(other.getAttendanceid()))
            && (this.getSirid() == null ? other.getSirid() == null : this.getSirid().equals(other.getSirid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getActualnumber() == null ? other.getActualnumber() == null : this.getActualnumber().equals(other.getActualnumber()))
            && (this.getAttendancecode() == null ? other.getAttendancecode() == null : this.getAttendancecode().equals(other.getAttendancecode()))
            && (this.getCourseid() == null ? other.getCourseid() == null : this.getCourseid().equals(other.getCourseid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttendanceid() == null) ? 0 : getAttendanceid().hashCode());
        result = prime * result + ((getSirid() == null) ? 0 : getSirid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getActualnumber() == null) ? 0 : getActualnumber().hashCode());
        result = prime * result + ((getAttendancecode() == null) ? 0 : getAttendancecode().hashCode());
        result = prime * result + ((getCourseid() == null) ? 0 : getCourseid().hashCode());
        return result;
    }
}