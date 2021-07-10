package domain;

public class Student {

    private Integer sid;
    private String sname;
    private Grade grade;

    public Student() {
    }

    public Student(Integer sid, String sname, Grade grade) {

        this.sid = sid;
        this.sname = sname;
        this.grade = grade;
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", grade=" + grade +
                '}';
    }
}
