package service;

import dao.DeptDao;
import domain.Dept;

import java.util.List;

public class DeptService {
    private DeptDao dao = new DeptDao();
    //设计一个方法用来查询单条记录
    public Dept selectOne(Integer deptno){
        return dao.selectOne(deptno);
    }

    //设计一个方法用来查询所有的部门信息和员工信息
    public List<Dept> selectAll(){
        return dao.selectAll();
    }
}
