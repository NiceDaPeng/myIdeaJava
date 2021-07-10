package dao;

import domain.Student;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

import java.util.List;

public class StudentDao {

    private SqlSession sqlSession = MyUtil.getSqlSession(true);

    //设计一个发方法用来查询学生的信息和所学老师的信息
    public Student selectOne(Integer sid){
        return sqlSession.selectOne("selectOne",sid);
    }

    //设计一个方法用来查询所有的学生的信息
    public List<Student> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
