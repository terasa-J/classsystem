package com.eva.classsystem.pojo;

import java.io.Serializable;

public class Notice implements Serializable {
    private Integer noticeid;

    private String sirid;

    private String createtime;

    private String title;

    private String content;

    private String courseid;

    private static final long serialVersionUID = 1L;

    public Notice(Integer noticeid, String sirid, String createtime, String title, String content, String courseid) {
        this.noticeid = noticeid;
        this.sirid = sirid;
        this.createtime = createtime;
        this.title = title;
        this.content = content;
        this.courseid = courseid;
    }

    public Notice() {
        super();
    }

    public Integer getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(Integer noticeid) {
        this.noticeid = noticeid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        Notice other = (Notice) that;
        return (this.getNoticeid() == null ? other.getNoticeid() == null : this.getNoticeid().equals(other.getNoticeid()))
            && (this.getSirid() == null ? other.getSirid() == null : this.getSirid().equals(other.getSirid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCourseid() == null ? other.getCourseid() == null : this.getCourseid().equals(other.getCourseid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoticeid() == null) ? 0 : getNoticeid().hashCode());
        result = prime * result + ((getSirid() == null) ? 0 : getSirid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCourseid() == null) ? 0 : getCourseid().hashCode());
        return result;
    }
}