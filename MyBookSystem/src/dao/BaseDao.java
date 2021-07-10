package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao  {

    private QueryRunner qr = new QueryRunner();

    //设计一个方法用来完成增删改操作
    public int update(String sql,Object... args){
        Connection conn = JdbcUtil.getConn();
        try {
            return qr.update(sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //设计一个方法用来完成查询一个用户
    public <T>T queryOne(String sql,Class<T> clazz,Object... args){
        Connection conn = JdbcUtil.getConn();
        try {
            return qr.query(conn, sql, new BeanHandler<T>(clazz),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //设计一个方法用来查询多个用户
    public <T>List<T> queryMore(String sql, Class<T> clazz, Object... args){
        Connection conn = JdbcUtil.getConn();
        try {
            return qr.query(conn,sql,new BeanListHandler<T>(clazz),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //设计一个方法用来查询单个数据
    public Object querySclar(String sql,Object... args){
        Connection conn = JdbcUtil.getConn();
        try {
           return qr.query(conn,sql,new ScalarHandler<>(),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
