package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyUtil {

    private static SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));

    //提供一个获取SqlSession对象的方法
    public static SqlSession getSqlsession(){
        return factory.openSession();
    }

    public static SqlSession getSqlSession(boolean flag)
    {
        return factory.openSession(flag);
    }

    //提供一个方法来获取Mapper代理对象
    public static <T> T getMapper(Class<T> clazz){
        return getSqlsession().getMapper(clazz);
    }

    public static <T>T getMapper(Class<T> clazz,boolean flag){
        return getSqlSession(flag).getMapper(clazz);
    }
}
