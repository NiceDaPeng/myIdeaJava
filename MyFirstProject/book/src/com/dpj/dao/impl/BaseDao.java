package com.dpj.dao.impl;

import com.dpj.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行增删改操作。
     * @param sql 操作的执行语句
     * @param args 操作的参数
     * @return 返回-1表示操作失败，返回别的值则表示操作成功
     */
    public int update(String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    /**
     * 查询一条javaBean的sql语句
     * @param type：返回的对象类型
     * @param sql 要执行的sql语句
     * @param args sql语句中的参数
     * @param <T>返回类型的泛型
     * @return 如果返回null则表示执行失败，非null则表示成功。
     */
    public <T>T queryForOne(Class<T> type,String sql,Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     *  查询返回一条JavaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 要执行的sql语句
     * @param args sql对应的参数
     * @param <T>返回类型的泛型
     * @return 如果返回null则表示执行失败，非null则表示成功。
     */
    public <T>List<T> queryForList(Class<T> type,String sql,Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return (List<T>) queryRunner.query(connection,sql,new BeanHandler<>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql查询语句
     * @param sql 要执行的sql语句
     * @param args sql中需要的参数
     * @return 如果返回null则表示执行失败，非null则表示成功
     */
    public Object queryForSingleValue(String sql,Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
