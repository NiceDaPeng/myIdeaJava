package dynamic;

import org.apache.ibatis.annotations.Param;

public class EmpDynamic {
    //类名随便写
    //方法名：如果类中只有一个方法，如果使用默认方法名，名字以后注解找的时候可以省略
    //默认方法名：provideSql（使用默认的则找寻时可以省略），如果方法名字是自己随意写的，也可以。
    //找寻的时候，就要需要告知注解具体哪个方法。
    //设计一个方法，目的是为了自己动态拼接sql
    //参数？需要  ；
    // 返回值？需要  目的是拼接sql的所以我们需要将其返回

    public String provideSql(@Param("job") String job, @Param("deptno") Integer deptno){
        StringBuilder builder = new StringBuilder();
        builder.append("select * from emp where 1=1");
        if (job != null && job != ""){
            builder.append(" and job = #{job} ");
        }
        if (deptno != null ){
            builder.append(" and deptno = #{deptno}");
        }

        return builder.toString();
    }
}
