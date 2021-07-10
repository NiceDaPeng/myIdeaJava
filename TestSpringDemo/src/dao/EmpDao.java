package dao;

import domain.Emp;
import dynamic.EmpDynamic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface EmpDao {

    //设计一个方法实现动态查询
    @SelectProvider(value = EmpDynamic.class,type = EmpDynamic.class,method = "selectStudentByDynamic")
    List<Emp> selectEmpByDynamic(@Param("deptno") Integer deptno, @Param("job") String job);
}
