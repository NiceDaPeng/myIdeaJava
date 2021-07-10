package dao;

import domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import util.MySqlSessionFactory;

import java.util.List;

public class StudentDao {

    private SqlSession sqlSession = MySqlSessionFactory.getSqlSession(true);
    //学生的注册
    public int insert(Student student){
        //找到sqlSession对象让它做事
        int insert = sqlSession.insert("insert", student);
        return insert;
    }

    public void update(Student student) {
        sqlSession.update("update",student);
    }

    public void delete(Integer sid) {
        sqlSession.delete("delete",sid);
    }

    public Student selectOne(Integer sid) {
        return sqlSession.selectOne("selectOne",sid);
    }

    public List<Student> selectAllByOrder(String flag) {

        return sqlSession.selectList("selectAllByOrder",flag);
    }
}
