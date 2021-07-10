package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtils;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class BaseDao {

    private QueryRunner qr = new QueryRunner();
    //修改信息
    public int update(String sql,Object... params){

        try {
            return qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //查询一条记录
    public <T>T queryOne(String sql,Class<T> clazz,Object... params){
        Connection conn = JdbcUtils.getConn();
        try {
            return qr.query(conn,sql,new BeanHandler<T>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //查询多条记录

    public <T>List<T> queryMore(String sql, Class<T> clazz, Object... params){
        Connection conn = JdbcUtils.getConn();
        try {
            return qr.query(conn,sql,new BeanListHandler<T>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //查询单个记录
    public Object queryScalar(String sql,Object... params){
        try {
           return qr.query(sql,new ScalarHandler<>(),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
