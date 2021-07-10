package dao;

import domain.Emp;
import dynamic.SelectEmpByDynamicSql;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface EmpDao {

    //设计一个方法根据编号和工作查询员工信息
    @SelectProvider(type = SelectEmpByDynamicSql.class,method = "provideSql")
    List<Emp> selectByDeptnoAndJob(@Param("deptno") Integer deptno, @Param("job") String job);

    //设计一个方法对数据库中的信息批量操作
    @SelectProvider(type = SelectEmpByDynamicSql.class,method = "getDynamicSql")
    List<Emp> selectEmpByEmpno(@Param("empnos")Integer... empnos);
}
