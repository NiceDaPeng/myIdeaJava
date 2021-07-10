package domain;

import java.util.List;

public class Teacher {

    private Integer tid;
    private String tname;
    private String tsex;
    private Integer tage;

    public Teacher() {}

    public Teacher(Integer tid, String tname, String tsex, Integer tage, List<Student> studentList) {

        this.tid = tid;
        this.tname = tname;
        this.tsex = tsex;
        this.tage = tage;
        this.studentList = studentList;
    }

    public Integer getTid() {

        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public Integer getTage() {
        return tage;
    }

    public void setTage(Integer tage) {
        this.tage = tage;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tage=" + tage +
                ", studentList=" + studentList +
                '}';
    }

    //    关联属性
    private List<Student> studentList;
}
