package com.dpj.entity;

import java.util.Date;

public class Student {

    private String sid;
    private String sname;
    private Integer gid;
    private String ssex;
    private Date sbirthday;
    private String saccount;
    private String spassword;

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", gid=" + gid +
                ", ssex='" + ssex + '\'' +
                ", sbirthday=" + sbirthday +
                ", saccount='" + saccount + '\'' +
                ", spassword='" + spassword + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String sid, String sname, Integer gid, String ssex, Date sbirthday, String saccount, String spassword) {
        this.sid = sid;
        this.sname = sname;
        this.gid = gid;
        this.ssex = ssex;
        this.sbirthday = sbirthday;
        this.saccount = saccount;
        this.spassword = spassword;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getSaccount() {
        return saccount;
    }

    public void setSaccount(String saccount) {
        this.saccount = saccount;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }
}
