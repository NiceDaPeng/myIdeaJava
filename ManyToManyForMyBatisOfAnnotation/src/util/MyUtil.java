package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyUtil {

    private static SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
    //设计一个方法用来获取SqlSession对象
    private static SqlSession getSqlSession(){
        return factory.openSession();
    }

    //设计一个重载方法带boolean参数的，true则表示自动提交事务，默认false需要手动提交事务
    private static SqlSession getSqlSession(boolean flag){
        return factory.openSession(flag);
    }

    //设计一个方法获取sqlSession的代理对象
    public static <T>T getMapper(Class<T> clazz,boolean flag){
        return getSqlSession(flag).getMapper(clazz);
    }

    //设计一个手动提交事务的获取代理对象的方法
    public static <T>T getMapper(Class<T> clazz){
        return getSqlSession().getMapper(clazz);
    }
}
