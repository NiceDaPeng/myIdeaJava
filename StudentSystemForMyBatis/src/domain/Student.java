package domain;


import java.sql.Date;

public class Student {

    private Integer sid;
    private String sname;
    private Integer gid;
    private String ssex;
    private Date sbirthday;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gid=" + gid +
                ", ssex='" + ssex + '\'' +
                ", sbirthday='" + sbirthday + '\'' +
                '}';
    }

    public Student() {
    }


    public Integer getSid() {

        return sid;
    }

    public void setSid(int sid1, String 令狐冲, int i, String 男, Integer sid) {
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

    public Student(Integer sid, String sname, Integer gid, String ssex, Date sbirthday) {

        this.sid = sid;
        this.sname = sname;
        this.gid = gid;
        this.ssex = ssex;
        this.sbirthday = sbirthday;
    }
}
