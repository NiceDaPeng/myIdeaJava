package dao;

import domain.Dept;
import domain.Emp;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import java.util.List;

public interface DeptDao {

    //根据部门id查询部门信息以及部门下的|所有员工信息
    @Results(
            id = "selectDeptByDeptno",
            value = {
                    @Result(property = "deptno",column = "deptno",id = true),
                    @Result(property = "dname",column = "dname"),
                    @Result(property = "loc",column = "loc"),
                    @Result(property = "empList",javaType = List.class,column = "deptno",
                    many = @Many(select = "selectEmp",fetchType = FetchType.LAZY)
                    )
            }
    )
    @Select("select * from dept where deptno = #{deptno}")
    Dept selectOne(Integer deptno);

    @Select("select * from emp where deptno=#{deptno}")
    Emp selectEmp(Integer empno);

    //设计一个方法用来查询全部的部门和下面的员工
    @ResultMap("selectDeptByDeptno")
    @Select("select * from dept")
    List<Dept> selectAll();
}
