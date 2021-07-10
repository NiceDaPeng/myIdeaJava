package domain;

import java.util.List;

public class Student {

    private Integer sid;
    private String sname;
    private String ssex;
    private Integer sage;
    private List<Teacher> teaList;

    public Student() {
    }

    public Student(Integer sid, String sname, String ssex, Integer sage, List<Teacher> teaList) {

        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.teaList = teaList;
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

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public List<Teacher> getTeaList() {
        return teaList;
    }

    public void setTeaList(List<Teacher> teaList) {
        this.teaList = teaList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", teaList=" + teaList +
                '}';
    }
}
