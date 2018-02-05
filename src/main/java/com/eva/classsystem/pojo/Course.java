package com.eva.classsystem.pojo;

import java.io.Serializable;

public class Course implements Serializable {
    private Integer id;

    private String invitationcode;

    private String sirid;

    private String cname;

    private String createtime;

    private String courseid;

    private static final long serialVersionUID = 1L;

    public Course(Integer id, String invitationcode, String sirid, String cname, String createtime, String courseid) {
        this.id = id;
        this.invitationcode = invitationcode;
        this.sirid = sirid;
        this.cname = cname;
        this.createtime = createtime;
        this.courseid = courseid;
    }

    public Course() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvitationcode() {
        return invitationcode;
    }

    public void setInvitationcode(String invitationcode) {
        this.invitationcode = invitationcode == null ? null : invitationcode.trim();
    }

    public String getSirid() {
        return sirid;
    }

    public void setSirid(String sirid) {
        this.sirid = sirid == null ? null : sirid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
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
        Course other = (Course) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInvitationcode() == null ? other.getInvitationcode() == null : this.getInvitationcode().equals(other.getInvitationcode()))
            && (this.getSirid() == null ? other.getSirid() == null : this.getSirid().equals(other.getSirid()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getCourseid() == null ? other.getCourseid() == null : this.getCourseid().equals(other.getCourseid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInvitationcode() == null) ? 0 : getInvitationcode().hashCode());
        result = prime * result + ((getSirid() == null) ? 0 : getSirid().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getCourseid() == null) ? 0 : getCourseid().hashCode());
        return result;
    }
}