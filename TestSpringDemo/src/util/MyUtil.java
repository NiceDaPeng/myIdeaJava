package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyUtil {

    private static SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    private static SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));

    public static SqlSession getSqlSession(boolean flag){
        return factory.openSession(flag);
    }

    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    public static <T>T getMapper(Class<T> clazz,boolean flag){
        return getSqlSession(flag).getMapper(clazz);
    }

    public static <T>T getMapper(Class<T> clazz){
        return getSqlSession().getMapper(clazz);
    }
}
