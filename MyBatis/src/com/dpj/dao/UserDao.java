package com.dpj.dao;

import com.dpj.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class UserDao {

    //设计一个方法用来查询所有的记录，并按照密码排序
    public List<User> selectByOrder(String desc){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
        SqlSession sqlSession = factory.openSession(true);
        return  sqlSession.selectList("selectByOrder",desc);
    }

    //设计一个方法用来修改用户的信息
    public int update(User user){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
        SqlSession sqlSession = factory.openSession(true);
        int update = sqlSession.update("update", user);
        return update;
    }

    //设计一个方法用来查询额外的记录
    public List<Map<String,Object>> selectScalar(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
        SqlSession sqlSession = factory.openSession(true);
        List<Map<String,Object>> scalarList = sqlSession.selectList("selectScalar");
        return scalarList;
    }
    //设计一个方法查询单个数据
    public int selecCount(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
        SqlSession sqlSession = factory.openSession(true);
        Integer count = sqlSession.selectOne("selectCount");
        return count;
    }

    //设计一个方法用来查询多条记录
    public List<User> selectAll(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
        SqlSession sqlSession = factory.openSession(true);
        List<User> userList = sqlSession.selectList("selectAll");
        return userList;
    }

    //设计一个方法用来查询一条记录
    public User selectOne(String uname){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory facotry = builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml"));
        SqlSession sqlSession = facotry.openSession(true);
        User user = sqlSession.selectOne("selectOne",uname);
        return user;
    }

    public void insert(){
        //先创建工人对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml");
        //先获取工厂对象
        SqlSessionFactory factory = builder.build(is);

        //获取MyBatis为我们提供的对象sqlSeesion
        SqlSession sqlSession = factory.openSession(true);
        //传递一个true则自动开启事务，默认提交事务，如果不写则自动开启事务，暂不提交
        sqlSession.insert("insert");
//        sqlSession.commit();//MyBatis是手动提交事务的。
    }


}
