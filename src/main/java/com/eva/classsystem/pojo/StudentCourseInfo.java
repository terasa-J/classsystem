package com.eva.classsystem.pojo;

import java.io.Serializable;

/**
 * @Author: Jiang Jiahong
 * @Description: 结合 Course表 以及 Student-Course 表 抽取字段，用于stuClass.jsp
 * @Date: 2018/1/27 15:27
 */
public class StudentCourseInfo implements Serializable {
    private Integer id;

    private String courseid;

    private String stuid;

    private String attendtime;

    private String invitationcode;

    private String sirid;

    private String cname;

    private String createtime;

    private String name;

    public StudentCourseInfo(Integer id, String courseid, String stuid, String attendtime, String invitationcode, String sirid, String cname, String createtime, String name) {
        this.id = id;
        this.courseid = courseid;
        this.stuid = stuid;
        this.attendtime = attendtime;
        this.invitationcode = invitationcode;
        this.sirid = sirid;
        this.cname = cname;
        this.createtime = createtime;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.courseid = courseid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getAttendtime() {
        return attendtime;
    }

    public void setAttendtime(String attendtime) {
        this.attendtime = attendtime;
    }

    public String getInvitationcode() {
        return invitationcode;
    }

    public void setInvitationcode(String invitationcode) {
        this.invitationcode = invitationcode;
    }

    public String getSirid() {
        return sirid;
    }

    public void setSirid(String sirid) {
        this.sirid = sirid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }




}
