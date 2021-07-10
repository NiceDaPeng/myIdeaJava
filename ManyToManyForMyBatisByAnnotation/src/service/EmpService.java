package service;

import dao.EmpDao;
import domain.Emp;
import util.MyUtil;

import java.util.List;

public class EmpService {
    private EmpDao dao = MyUtil.getMapper(EmpDao.class,true);
    //给定两个不同的条件，job deptno，两个选项提供给用户选择，可有可无，
    //根据用户选择的条件动态的拼接sql来执行查询操作，
    //没有条件 ：select * from emp;
    //有一个deptno ：select * from emp where deptno=#{deptno}
    //有一个job ：select * from emp where job = #{job}
    //都选择了：select * from emp where job = #{job} and deptno=#{deptno}
    //Mybatis给我们提供的动态查询标签 <where> <if> <foreach>

    //
    public List<Emp> selectEmpByDeptnoAndJob(String job,Integer deptno){
        return dao.selectEmpByDeptnoAndJob(job,deptno);
    }
}
