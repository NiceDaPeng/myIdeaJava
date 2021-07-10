package dao;

import domain.Student;
import proxy.SqlSession;
import proxy.SqlSessionFactory;

public class StudentDao {

    private SqlSession sqlSession = new SqlSessionFactory().openSession();
    //有一个具体的方法负责数据库的写操作
    public void insert(Student student) {

        //需要一个sqlSession对象
        sqlSession.insert("sqlid",student);
    }
}
