package dao;

import domain.Dept;
import domain.Emp;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface EmpDao {

    //根据员工编号查询员工信息以及部门信息
//    @Select("select * from emp")
//    @Results(
//            id = "selectOne",
//            value = {
//                    @Result()
//            }
//    )

    //根据员工编号查询员工信息和部门信息
    @Results(
            id = "selectEmp",
            value={
                    @Result(property = "empno",column="empno",id = true),
                    @Result(property = "ename",column = "ename"),
                    @Result(property = "sal",column = "sal"),
                    @Result(property = "job",column = "job"),
                    @Result(property = "dept",column = "deptno",javaType = Dept.class,
                    one=@One(select = "selectDept",fetchType = FetchType.LAZY))
            }
    )
    @Select("select * from emp where empno=#{empno}")
    Emp selectOne(Integer empno);

    //辅助方法
    @Select("select * from dept where deptno=#{deptno}")
    Dept selectDept(Integer deptno);

    @ResultMap("selectEmp")
    @Select("select * from emp")
    List<Emp> selectAll();
}
