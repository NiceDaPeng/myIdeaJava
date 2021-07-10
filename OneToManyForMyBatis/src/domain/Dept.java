package domain;

import java.util.List;

public class Dept {

    private Integer deptno;
    private String dname;
    private String loc;
    //为了查询部门中所有的人更加方便，也存储一个关联属性
    private List<Emp> empList;
    public Dept() {}
    public Dept(Integer deptno, String dname, String loc, List<Emp> empList) {

        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
        this.empList = empList;
    }

    public List<Emp> getEmpList() {

        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public Integer getDeptno() {

        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", empList=" + empList +
                '}';
    }
}
