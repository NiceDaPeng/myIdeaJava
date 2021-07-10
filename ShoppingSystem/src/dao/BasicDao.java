package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDao {

    private QueryRunner qr = new QueryRunner();

    /**
     * 修改数据
     * @param sql 执行修改的sql
     * @param params 动态参数
     * @return 修改成功影响的行数 返回-1 则说明修改失败。
     */
    //设计一个方法用来修改数据
    public int update(String sql,Object... params){
        Connection conn = JdbcUtils.getConn();
        try {
            return qr.update(conn,sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,null,conn);
        }
        return -1;
    }

    /**
     * 查询一条记录
     * @param sql
     * @param clazz
     * @param params
     * @param <T>
     * @return
     */
    //设计一个方法用来查询一条记录
    public <T>T queryOne(String sql,Class<T> clazz,Object... params){
        Connection conn = JdbcUtils.getConn();
        try {
            return qr.query(conn,sql,new BeanHandler<T>(clazz),params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,null,conn);
        }
        return null;
    }

    //查询多条记录

    /**
     * 查询多条记录，
     * @param sql  要执行的SQL语句
     * @param clazz 查询多条语句以后封装的类型
     * @param params 动态参数
     * @param <T> 集合的类型
     * @return 返回null 说明没有查到 否则返回集合地址
     */
    public <T>List<T> queryMore(String sql, Class<T> clazz, Object... params){
        Connection conn = JdbcUtils.getConn();
        try {
            return qr.query(conn,sql,new BeanListHandler<T>(clazz),params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,null,conn);
        }
        return null;
    }

    //查询单个信息

    /**
     * 查询单个记录
     * @param sql 要执行的sql语句
     * @param params 动态参数
     * @return 返回单挑记录的结果 否则返回null
     */
    public Object queryScalar(String sql,Object... params){
        Connection conn = JdbcUtils.getConn();
        try {
           return  qr.query(conn,sql,new ScalarHandler<>(),params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,null,conn);
        }
        return null;
    }

}
