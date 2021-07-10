package dao;

import domain.Emp;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    //设计一个方法用来查询所有的部门编号
    public List<Integer> selectAllDept();

    //设计一个方法用来查询所有员工的工作类型
    public List<String> selectAllJob();

    //设计一个方法用来查询部门对应的信息和工作对应的员工信息
    public List<Emp> selectEmp(Map<String,Object> params);

    //设计一个方法用来查询所有的员工信息
    public List<Emp> selectAllEmp();

    public void updateEmp(List<String> empnos);

    //设计一个方法用来更新信息

}
