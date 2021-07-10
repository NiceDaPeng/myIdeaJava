package dynamic;

public class SelectStudentByDynamic {

    //设计一个方法用来拼接sql
    public String provideSql(Integer deptno,String sname){
        StringBuilder builder = new StringBuilder();
        builder.append("select * from Student where 1 = 1");
        if (deptno != null){
            builder.append(" and deptno = #{deptno}");
        }
        if (sname != null && sname != ""){
            builder.append(" and sname = #{sname}");
        }
        return builder.toString();
    }
}
