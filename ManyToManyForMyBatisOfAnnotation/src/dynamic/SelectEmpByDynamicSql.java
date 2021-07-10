package dynamic;

import org.apache.ibatis.annotations.Param;

public class SelectEmpByDynamicSql {

    //设计一个方法用来拼接动态sql
    public String provideSql(@Param("deptno") Integer deptno, @Param("job") String job){
        StringBuilder builder = new StringBuilder();
        builder.append("select * from emp where 1= 1");
        if (job != null && job != ""){
            builder.append(" and deptno = #{deptno}");
        }
        if (deptno != null){
            builder.append(" and job = #{job}");
        }
        return builder.toString();
    }

    //设计一个方法用来拼接sql
    public String getDynamicSql(@Param("empnos")Integer... empnos){
        StringBuilder builder = new StringBuilder();
        builder.append("select * from emp where empno in");
        builder.append("(");
        for (int i = 0; i < empnos.length; i++) {
            builder.append(empnos[i]);
            builder.append(",");
        }
        builder.delete(builder.length()-1,builder.length());
        builder.append(")");
        return builder.toString();
    }
}
