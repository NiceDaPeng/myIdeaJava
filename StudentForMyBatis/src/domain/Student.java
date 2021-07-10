package domain;

import java.sql.Date;

public class Student {

    private String saccount;
    private String sname;
    private Integer sid;
    private Integer gid;
    private String ssex;
    private Date sbirthday;
    private String spassword;

    public Student(String saccount, String sname, Integer sid, Integer gid, String ssex, Date sbirthday, String spassword) {
        this.saccount = saccount;
        this.sname = sname;
        this.sid = sid;
        this.gid = gid;
        this.ssex = ssex;
        this.sbirthday = sbirthday;
        this.spassword = spassword;
    }

    public String getSpassword() {

        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    @Override
    public String toString() {
        return "Student{" +
                "saccount='" + saccount + '\'' +
                ", sname='" + sname + '\'' +
                ", sid=" + sid +
                ", gid=" + gid +
                ", ssex='" + ssex + '\'' +
                ", sbirthday=" + sbirthday +
                '}';
    }

    public Student() {
    }

    public Student(String saccount, String sname, Integer sid, Integer gid, String ssex, Date sbirthday) {

        this.saccount = saccount;
        this.sname = sname;
        this.sid = sid;
        this.gid = gid;
        this.ssex = ssex;
        this.sbirthday = sbirthday;
    }

    public String getSaccount() {

        return saccount;
    }

    public void setSaccount(String saccount) {
        this.saccount = saccount;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
}
