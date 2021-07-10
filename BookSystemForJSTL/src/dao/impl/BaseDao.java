package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 修改一条记录
     * @param sql
     * @param parmas
     * @return
     */
    public int update(String sql,Object... parmas){
        Connection conn = JdbcUtils.getConn();
        try {
            return queryRunner.update(conn, sql, parmas);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,null,conn);
        }
        return -1;
    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param sql 查询的语句
     * @param type
     * @param params
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T>T queryForOne(String sql,Class<T> type,Object... params){
        Connection conn = JdbcUtils.getConn();
        try {
           return  queryRunner.query(conn,sql,new BeanHandler<T>(type),params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,null,conn);
        }
        return null;
    }

    /**
     * 查询返回多个JavaBean对象的SQL语句
     * @param sql
     * @param type
     * @param params
     * @param <T>
     * @return
     */
    public <T>List<T> queryForList(String sql, Class<T> type, Object... params){
        Connection conn = JdbcUtils.getConn();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,null,conn);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql 执行的sql语句
     * @param params  sql对应的动态参数值
     * @return
     */
    public Object queryForSingleValue(String sql,Object... params){
        Connection conn = JdbcUtils.getConn();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,null,conn);
        }
        return null;
    }
}
