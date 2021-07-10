package domain;

import java.util.List;

public class Teacher {

    private Integer tid;
    private String tname;
    private String tsex;
    private Integer tage;
    private List<Student> studentList;

    public Teacher() {
    }

    public Integer getTid() {
        return this.tid;
    }

    public String getTname() {
        return this.tname;
    }

    public String getTsex() {
        return this.tsex;
    }

    public Integer getTage() {
        return this.tage;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public void setTage(Integer tage) {
        this.tage = tage;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Teacher)) return false;
        final Teacher other = (Teacher) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$tid = this.getTid();
        final Object other$tid = other.getTid();
        if (this$tid == null ? other$tid != null : !this$tid.equals(other$tid)) return false;
        final Object this$tname = this.getTname();
        final Object other$tname = other.getTname();
        if (this$tname == null ? other$tname != null : !this$tname.equals(other$tname)) return false;
        final Object this$tsex = this.getTsex();
        final Object other$tsex = other.getTsex();
        if (this$tsex == null ? other$tsex != null : !this$tsex.equals(other$tsex)) return false;
        final Object this$tage = this.getTage();
        final Object other$tage = other.getTage();
        if (this$tage == null ? other$tage != null : !this$tage.equals(other$tage)) return false;
        final Object this$studentList = this.getStudentList();
        final Object other$studentList = other.getStudentList();
        if (this$studentList == null ? other$studentList != null : !this$studentList.equals(other$studentList))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Teacher;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $tid = this.getTid();
        result = result * PRIME + ($tid == null ? 43 : $tid.hashCode());
        final Object $tname = this.getTname();
        result = result * PRIME + ($tname == null ? 43 : $tname.hashCode());
        final Object $tsex = this.getTsex();
        result = result * PRIME + ($tsex == null ? 43 : $tsex.hashCode());
        final Object $tage = this.getTage();
        result = result * PRIME + ($tage == null ? 43 : $tage.hashCode());
        final Object $studentList = this.getStudentList();
        result = result * PRIME + ($studentList == null ? 43 : $studentList.hashCode());
        return result;
    }

    public String toString() {
        return "Teacher(tid=" + this.getTid() + ", tname=" + this.getTname() + ", tsex=" + this.getTsex() + ", tage=" + this.getTage() + ", studentList=" + this.getStudentList() + ")";
    }
}
