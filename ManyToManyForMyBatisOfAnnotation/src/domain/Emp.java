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

        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Float getSal() {
        return sal;
    }

    public void setSal(Float sal) {
        this.sal = sal;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                ", deptno=" + deptno +
                ", job='" + job + '\'' +
                '}';
    }
}
