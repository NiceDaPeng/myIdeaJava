package dao;

import domain.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import util.MyUtil;

import java.util.List;

public class PersonDao {

    private SqlSession sqlSession = MyUtil.getSqlSession(true);
    //设计一个方法用来查询一个人的信息
    public Person selectOne(Integer pid){
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
//        SqlSession sqlSession = factory.openSession(true);
        return sqlSession.selectOne("selectOne", pid);
    }

    //设计一个方法用来查询多条记录
    public List<Person> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
