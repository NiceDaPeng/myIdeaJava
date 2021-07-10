package domain;

public class Emp {

    private Integer empno;
    private String ename;
    private Float sal;
    private Integer deptno;
    private String job;

    public Emp() {
    }

    public Emp(Integer empno, String ename, Float sal, Integer deptno, String job) {
        this.empno = empno;
        this.ename = ename;
        this.sal = sal;
        this.deptno = deptno;
        this.job = job;
    }


    public Integer getEmpno() {
        return this.empno;
    }

    public String getEname() {
        return this.ename;
    }

    public Float getSal() {
        return this.sal;
    }

    public Integer getDeptno() {
        return this.deptno;
    }

    public String getJob() {
        return this.job;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSal(Float sal) {
        this.sal = sal;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Emp)) return false;
        final Emp other = (Emp) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$empno = this.getEmpno();
        final Object other$empno = other.getEmpno();
        if (this$empno == null ? other$empno != null : !this$empno.equals(other$empno)) return false;
        final Object this$ename = this.getEname();
        final Object other$ename = other.getEname();
        if (this$ename == null ? other$ename != null : !this$ename.equals(other$ename)) return false;
        final Object this$sal = this.getSal();
        final Object other$sal = other.getSal();
        if (this$sal == null ? other$sal != null : !this$sal.equals(other$sal)) return false;
        final Object this$deptno = this.getDeptno();
        final Object other$deptno = other.getDeptno();
        if (this$deptno == null ? other$deptno != null : !this$deptno.equals(other$deptno)) return false;
        final Object this$job = this.getJob();
        final Object other$job = other.getJob();
        if (this$job == null ? other$job != null : !this$job.equals(other$job)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Emp;
    }
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $empno = this.getEmpno();
        result = result * PRIME + ($empno == null ? 43 : $empno.hashCode());
        final Object $ename = this.getEname();
        result = result * PRIME + ($ename == null ? 43 : $ename.hashCode());
        final Object $sal = this.getSal();
        result = result * PRIME + ($sal == null ? 43 : $sal.hashCode());
        final Object $deptno = this.getDeptno();
        result = result * PRIME + ($deptno == null ? 43 : $deptno.hashCode());
        final Object $job = this.getJob();
        result = result * PRIME + ($job == null ? 43 : $job.hashCode());
        return result;
    }

    public String toString() {
        return "Emp(empno=" + this.getEmpno() + ", ename=" + this.getEname() + ", sal=" + this.getSal() + ", deptno=" + this.getDeptno() + ", job=" + this.getJob() + ")";
    }
}
