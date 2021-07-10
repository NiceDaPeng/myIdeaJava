package service;

import dao.DeptDao;
import domain.Dept;
import util.MyUtil;

import java.util.List;

public class DeptService {
    private DeptDao dao = MyUtil.getMapper(DeptDao.class);
    //设计一个方法通过给定的部门编号查询部门信息
    public Dept selectDept(Integer deptno){
        return dao.selectOne(deptno);
    }

    //设计一个方法用来查询所有部门的员工信息，包括每个部门下的员工信息
    public List<Dept> selectAll(){
        return dao.selectAll();
    }
}
