package service;

import dao.EmpDao;
import domain.Emp;
import util.MyUtil;

import java.util.List;

public class EmpService {
    private EmpDao dao = MyUtil.getMapper(EmpDao.class,true);
    //根据给定的员工的编号查询员工的信息和其对应部门的信息
    public Emp selectOne(Integer empno){
        return dao.selectOne(empno);
    }

    //设计一个方法用来查询所有的员工信息
    public List<Emp> selectAll(){
        return dao.selectAll();
    }
}
