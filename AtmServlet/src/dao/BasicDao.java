package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JDBCUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDao {
    private QueryRunner qr = new QueryRunner();
    //设计一个方法用来实现增删改
    public int update(String sql,Object... params){
        Connection conn = JDBCUtil.getConn();
        try {
            int update = qr.update(conn, sql, params);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCUtil.close(null,null,conn);
        }
    }

    //设计一个方法用来查询一条记录
    public <T>T queryOne(String sql,Class<T> clazz,Object... params){
        Connection conn = JDBCUtil.getConn();
        T oneMessage = null;
        try {
            oneMessage = qr.query(conn, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null,null,conn);
        }
        return oneMessage;
    }


    //设计一个方法用来查询多条记录
    public <T>List<T> queryMore(String sql, Class<T> clazz, Object... params){
        Connection conn = JDBCUtil.getConn();
        List<T> list = null;
        try {
            list = qr.query(conn, sql, new BeanListHandler<T>(clazz), params);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(null,null,conn);
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //设计一个方法用来查询单挑记录
    public Object queryScalar(String sql,Object... params){
        Connection conn = JDBCUtil.getConn();
        try {
            Object query = qr.query(conn, sql, new ScalarHandler(), params);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(null,null,conn);
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
