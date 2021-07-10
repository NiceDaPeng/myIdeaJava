package domain;

import java.util.List;

public class Student {

    private Integer sid;
    private String sname;
    private String ssex;
    private Integer sage;
//    关联属性
    private List<Teacher> teacherList;

    public Student() {}

    public Student(Integer sid, String sname, String ssex, Integer sage, List<Teacher> teacherList) {

        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.teacherList = teacherList;
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

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", teacherList=" + teacherList +
                '}';
    }
}
