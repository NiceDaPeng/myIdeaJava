package com.dpj.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyUtil {

    //设计一个方法获取sqlSessionFactory对象

    private static SqlSessionFactory factory ;
    static {
        factory = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
    }


    //设计一个方法获取sqlSession对象
    public static SqlSession getSqlSession(boolean flag){
        return factory.openSession(flag);
    }

    public static SqlSession getSqlSession(){
        return factory.openSession(false);
    }

    //设计一个方法获取代理对象
    public static <T>T getMapper(boolean flag,Class<T> clazz){
        T mapper = getSqlSession(flag).getMapper(clazz);
        return mapper;
    }
}
