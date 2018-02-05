package com.eva.classsystem.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;

    private String email;

    private String password;

    private String name;

    private String stuid;

    private String school;

    private String headimg;

    private String calssno;

    private String major;

    private static final long serialVersionUID = 1L;

    public Student(Integer id, String email, String password, String name, String stuid, String school, String headimg, String calssno, String major) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.stuid = stuid;
        this.school = school;
        this.headimg = headimg;
        this.calssno = calssno;
        this.major = major;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getCalssno() {
        return calssno;
    }

    public void setCalssno(String calssno) {
        this.calssno = calssno == null ? null : calssno.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
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
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStuid() == null ? other.getStuid() == null : this.getStuid().equals(other.getStuid()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getHeadimg() == null ? other.getHeadimg() == null : this.getHeadimg().equals(other.getHeadimg()))
            && (this.getCalssno() == null ? other.getCalssno() == null : this.getCalssno().equals(other.getCalssno()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStuid() == null) ? 0 : getStuid().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getHeadimg() == null) ? 0 : getHeadimg().hashCode());
        result = prime * result + ((getCalssno() == null) ? 0 : getCalssno().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        return result;
    }
}