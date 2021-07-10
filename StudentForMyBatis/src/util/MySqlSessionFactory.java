package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {

    private static SqlSessionFactory factory;
    private static SqlSession sqlSession;

    static {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));

    }

    public static SqlSession getSqlSession(boolean flag){
       sqlSession = factory.openSession(flag);
       return sqlSession;
    }
}
