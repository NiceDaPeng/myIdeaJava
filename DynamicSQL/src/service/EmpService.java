package service;

import dao.EmpDao;
import domain.Emp;
import util.MyUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpService {
    private EmpDao dao = MyUtil.getSqlSession(true).getMapper(EmpDao.class);
    //设计一个方法用来查询所有的部门编号
    public List<Integer> selectAllDept(){
        return dao.selectAllDept();
    }

    //设计一个方法用来查询所有员工的工作种类 --去重
    public List<String> selectAllJob(){
        return dao.selectAllJob();
    }

    //设计一个方法用来查询部门编号的员工和工作类型不同的员工
    public List<Emp> selectEmp(String deptno,String job){
        Map<String,Object> empMap = new HashMap<>();
        empMap.put("deptno",deptno);
        empMap.put("job",job);
        return dao.selectEmp(empMap);
    }

    //设计一个方法用来查询所有的员工的信息
    public List<Emp> selectAllEmp(){
        return dao.selectAllEmp();
    }

    public void updateEmp(String[] empnos) {
        dao.updateEmp(Arrays.asList(empnos));
    }
}
