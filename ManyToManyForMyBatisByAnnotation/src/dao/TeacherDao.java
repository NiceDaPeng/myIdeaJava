package dao;

import domain.Student;
import domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface TeacherDao {

    //设计一个方法根据老师的id查询老师的信息和其所教学生的信息
    @Results(
            id = "selectTeacher",
            value = {
                    @Result(property = "tid",column = "tid",id = true),
                    @Result(property = "tname",column = "tname"),
                    @Result(property = "tsex",column = "tsex"),
                    @Result(property = "tage",column = "tage"),
                    @Result(property = "stuList",javaType = List.class,column = "tid",
                    many = @Many(select = "selectStudent",fetchType = FetchType.LAZY)
                    )
            }
    )
    @Select("select * from teacher where tid=#{tid}")
    Teacher selectOne(Integer tid);

    //设计一个辅助方法
    @Select("select * from student s inner join tea_stu ts on ts.sid = s.sid where ts.tid = #{tid}")
    Student selectStudent(Integer tid);

    //设计一个方法用来查询所有的老师的信息
    @ResultMap("selectTeacher")
    @Select("select * from teacher ")
    List<Teacher> selectAll();
}
