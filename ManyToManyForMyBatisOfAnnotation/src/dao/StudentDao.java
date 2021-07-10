package dao;

import domain.Student;
import domain.Teacher;
import dynamic.SelectStudentByDynamic;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentDao {

    //设计一个方法根据学生的编号查询学生的信息
    @Results(
            id = "selectStudent",
            value={
                    @Result(property = "sid",column = "sid",id = true),
                    @Result(property = "sname",column = "sname"),
                    @Result(property = "ssex",column = "ssex"),
                    @Result(property = "sage",column = "sage"),
                    @Result(property = "teacherList",javaType = List.class,column = "sid",
                            many = @Many(select="selectTeacher",fetchType = FetchType.LAZY))
            }
    )
    @Select("select * from student where sid = #{sid}")
    Student selectOne(Integer sid);

    //设计一个辅助方法用来查询老师的信息
    @Select("select * from teacher t inner join tea_stu ts on ts.tid = t.tid where ts.sid=#{sid}")
    Teacher selectTeacher(Integer sid);

    //设计一个方法用来获取全部的学生信息以及其所报的课程老师信息
    @ResultMap("selectStudent")
    @Select("select * from student")
    List<Student> selectAll();

    //设计一个方法用来实现动态查询

//    @SelectProvider(value=SelectStudentByDynamic.class,type = SelectStudentByDynamic.class,method = "getSql")
    List<Student> selectDynamic(Integer sid,String sname);
}
