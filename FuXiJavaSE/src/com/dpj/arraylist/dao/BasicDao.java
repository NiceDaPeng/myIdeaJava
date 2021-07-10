package com.dpj.arraylist.dao;

import com.dpj.arraylist.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDao<T> {
    private QueryRunner qr = new QueryRunner();
    //设计一个方法用来对数据库中的数据进行增删改操作
    public int update(String sql,Object... params){
        Connection conn = JDBCUtil.getConn();

        try {
            int update = qr.update(conn, sql, params);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(null,null,conn);
        }
    }

    //设计一个方法用来查询数据库中的一条信息

    public <T>T selectOne(String sql,Class clazz,Object... args){
        Connection conn = JDBCUtil.getConn();
        T obj = null;
        try {
            obj = (T) qr.query(conn,sql,new BeanHandler<>(clazz),args);
            return obj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(null,null,conn);
        }
    }

    //设计一个方法用来查询多条记录
    public <T>List<T> selectList(String sql,Class<T> clazz,Object... args){
        Connection conn = JDBCUtil.getConn();
        List<T> list = null;
        try {
            list = qr.query(conn,sql,new BeanListHandler<T>(clazz),args);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(null,null,conn);
        }
    }

    public <T>T queryScalar(String sql,Object... args){
        Connection conn = JDBCUtil.getConn();
        try {

            T query = qr.query(conn,sql, new ScalarHandler<>(), args);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(null,null,conn);
        }
    }

}
