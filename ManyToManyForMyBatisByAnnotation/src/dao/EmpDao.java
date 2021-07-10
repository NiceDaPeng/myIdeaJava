package dao;

import domain.Emp;
import dynamic.EmpDynamic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface EmpDao {

    /**
     * 支持动态SQL的方法
     */

    //根据给定的deptno和job查询人员信息
    //deptno 和job的具体不确定
    @SelectProvider(value = EmpDynamic.class,type = EmpDynamic.class,method = "provideSql")
    List<Emp> selectEmpByDeptnoAndJob(@Param("job")String job, @Param("deptno") Integer deptno);


    //根据给定的好多empno查询符合条件的人。
    List<Emp> selectMany(Integer... params);
}
