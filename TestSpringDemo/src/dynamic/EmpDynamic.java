package dynamic;

import org.apache.ibatis.annotations.Param;

public class EmpDynamic {

    //设计一个方法用来拼接动态查询学生信息的sql语句
    public String selectStudentByDynamic(@Param("deptno") Integer deptno, @Param("job") String job){
        StringBuilder sb = new StringBuilder("select * from emp where 1=1");
        if (deptno != null){
            sb.append(" and deptno = {deptno}");
        }
        if (job != null && job != ""){
            sb.append(" and job = #{job}");
        }

        return sb.toString();
    }
}
