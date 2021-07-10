package dao;

import domain.Student;
import domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentDao {

    //设计一个方法根据学生的编号查询学生的信息
    @Results(
            id = "selectStudent",
            value = {
                    @Result(property = "sid",column = "sid",id = true),
                    @Result(property = "sname",column = "sname"),
                    @Result(property = "ssex",column = "ssex"),
                    @Result(property = "sage",column = "sage"),
                    @Result(property = "teaList",javaType = List.class,column = "sid",
                            many =@Many(select = "selectTeacher",fetchType = FetchType.LAZY) )
            }
    )
    @Select("select * from student where sid = #{sid}")
    Student selectOne(Integer sid);

    //设计一个辅助方法用来查询学生对应的老师信息
    @Select("select t.* from teacher t inner join tea_stu ts on t.tid=ts.tid where ts.sid=#{sid}")
    Teacher selectTeacher(Integer sid);

    //设计一个方法用来查询所有的学生信息和其学习的老师的课程
    @ResultMap("selectStudent")
    @Select("select * from student")
    List<Student> selectAll();
}
