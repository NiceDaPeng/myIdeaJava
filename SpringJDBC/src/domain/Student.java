package domain;

public class Student {
    private Integer sid;
    private String sname;
    private String ssex;
    private Integer sage;

    public Student() {
    }

    public Student(Integer sid, String sname, String ssex, Integer sage) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
    }

    public Integer getSid() {
        return this.sid;
    }

    public String getSname() {
        return this.sname;
    }

    public String getSsex() {
        return this.ssex;
    }

    public Integer getSage() {
        return this.sage;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$sid = this.getSid();
        final Object other$sid = other.getSid();
        if (this$sid == null ? other$sid != null : !this$sid.equals(other$sid)) return false;
        final Object this$sname = this.getSname();
        final Object other$sname = other.getSname();
        if (this$sname == null ? other$sname != null : !this$sname.equals(other$sname)) return false;
        final Object this$ssex = this.getSsex();
        final Object other$ssex = other.getSsex();
        if (this$ssex == null ? other$ssex != null : !this$ssex.equals(other$ssex)) return false;
        final Object this$sage = this.getSage();
        final Object other$sage = other.getSage();
        if (this$sage == null ? other$sage != null : !this$sage.equals(other$sage)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Student;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $sid = this.getSid();
        result = result * PRIME + ($sid == null ? 43 : $sid.hashCode());
        final Object $sname = this.getSname();
        result = result * PRIME + ($sname == null ? 43 : $sname.hashCode());
        final Object $ssex = this.getSsex();
        result = result * PRIME + ($ssex == null ? 43 : $ssex.hashCode());
        final Object $sage = this.getSage();
        result = result * PRIME + ($sage == null ? 43 : $sage.hashCode());
        return result;
    }

    public String toString() {
        return "Student(sid=" + this.getSid() + ", sname=" + this.getSname() + ", ssex=" + this.getSsex() + ", sage=" + this.getSage() + ")";
    }
}
