package dao;

import domain.Student;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

public class StudentDao {
    SqlSession sqlSession =  MySqlSessionFactory.getSqlSession(true);

    //设计一个方法用来查询单挑记录
    public Student selectOne(String username){
        return sqlSession.selectOne("selectOne", username);
    }
}
