package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicDao {


    //设计一个方法用来实现增删改查操作
    public int update(String sql,Object... params){
        Connection conn = JDBCUtil.getConn();
        QueryRunner qr = new QueryRunner();
        int update = 0;
        try {
            update = qr.update(conn, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConn(null,null,conn);
        }
        return update;
    }

    //设计一个方法用来实现查询一条记录
    public <T>T selectOne(String sql,Class<T> clazz,Object... params){
        Connection conn = null;
        T message = null;
        try {
            conn = JDBCUtil.getConn();
            QueryRunner qr = new QueryRunner();
            message = qr.query(conn, sql, new BeanHandler<T>(clazz), params);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(null,null,conn);
        }
        return message;
    }

    //设计一个方法用来实现查询多条记录
    public <T> List<T> selectMulti(String sql,Class clazz, Object... params){
        Connection conn = null;
        List<T> list = null;
        QueryRunner qr = new QueryRunner();
        try {
            list = qr.query(conn, sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(null,null,conn);
        }
        return list;
    }
}
