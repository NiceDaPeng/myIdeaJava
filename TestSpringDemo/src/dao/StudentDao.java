package dao;

import domain.Student;
import domain.Teacher;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentDao {
    @Results(
            id = "selectOneStudent",
            value = {
                    @Result(property = "sid",column = "sid",id = true),
                    @Result(property = "sname",column = "sname"),
                    @Result(property = "ssex",column = "ssex"),
                    @Result(property = "sage",column = "sage"),
                    @Result(property = "teacherList",javaType = List.class,column = "sid",
                    many = @Many(
                            select = "selectTeacherBySid",
                            fetchType = FetchType.LAZY
                    ))
            }
    )

    @Select("select * from student where sid=#{sid}")
    Student selectOne(@Param("sid") Integer sid);

    //设计一个辅助方法
    @Select("select * from teacher t inner join tea_stu ts on ts.tid=t.tid where ts.sid=#{sid}")
    Teacher selectTeacherBySid(@Param("sid") Integer sid);


}
