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

    //设计一个方法用来获取sqlSession对象
    public static SqlSession getSqlSession(){

        return getSqlSession(false);
    }

    /**
     *
     * @param flag  是否自动提交，默认是手动提交的。
     * @return
     */
    public static SqlSession getSqlSession(boolean flag){
        return factory.openSession(flag);
    }
}
