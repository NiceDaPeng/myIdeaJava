package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyUtil {

    private static SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));

    //设计一个方法用来获取sqlSession对象
    private static SqlSession getSqlSession(){
        return factory.openSession();
    }

    private static SqlSession getSqlSession(boolean flag){
        return factory.openSession(true);
    }
    //设计一个方法用来获取代理对象
    public static <T>T getMapper(Class<T> clazz){
        return getSqlSession().getMapper(clazz);
    }

    public static <T>T getMapper(Class<T> clazz, boolean flag){
        return getSqlSession().getMapper(clazz);
    }
}
