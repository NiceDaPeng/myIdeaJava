package service;

import dao.EmpDao;
import domain.Emp;
import util.MyUtil;

import java.util.List;

public class EmpService {

    private EmpDao dao = MyUtil.getMapper(EmpDao.class,true);
    //设计一个方法根据编号和job来查询员工的信息
    public List<Emp> selectByDeptnoAndJob(Integer deptno,String job){
       return dao.selectByDeptnoAndJob(deptno,job);
    }

    //设计一个方法用来执行批量操作
    public List<Emp> selectEmpByEmpno(Integer... params){
        return dao.selectEmpByEmpno(params);
    }
}
