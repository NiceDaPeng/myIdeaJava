package com.dpj.domain;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

    private static final long serialVersionUID = 1964115307307500691L;
    private Integer sid;
    private String sname;
    private Integer gid;
    private String ssex;
    private Date sbir;
    private String saccount;
    private String spassword;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gid=" + gid +
                ", ssex='" + ssex + '\'' +
                ", sbir=" + sbir +
                ", saccount='" + saccount + '\'' +
                ", spassword='" + spassword + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(Integer sid, String sname, Integer gid, String ssex, Date sbir, String saccount, String spassword) {
        this.sid = sid;
        this.sname = sname;
        this.gid = gid;
        this.ssex = ssex;
        this.sbir = sbir;
        this.saccount = saccount;
        this.spassword = spassword;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
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

    public Date getSbir() {
        return sbir;
    }

    public void setSbir(Date sbir) {
        this.sbir = sbir;
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
