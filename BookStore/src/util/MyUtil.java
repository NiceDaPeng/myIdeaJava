package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyUtil {

    private static SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));

    /**
     * 获取sqlSession对象
     * @return
     */
    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    /**
     * 获取SqlSession对象
     * @param flag 是否自动提交事务
     * @return
     */
    public static SqlSession getSqlSession(boolean flag){
        return factory.openSession(flag);
    }

    /**
     * 获取类的代理对象
     * @param clazz  需要被代理的类
     * @param flag 是否自动提交事务，true自动提交 false手动提交
     * @param <T>  返回被代理类的类型
     * @return  返回被代理类的代理对象
     */
    public static <T>T getMapper(Class<T> clazz,boolean flag){
        return getSqlSession(flag).getMapper(clazz);
    }

}
