package dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import domain.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JDBCUtil;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DaoForAll {
    private QueryRunner qr = new QueryRunner();
    //普通链接数据库的方法
    public void firstGetConn() throws Exception {
        String url="jdbc:mysql://localhost:3306/test";
        String user= "root";
        String password="admin";
        String className = "com.mysql.jdbc.Driver";
        //加载驱动类
        Class.forName(className);
        //获取链接
        Connection conn = DriverManager.getConnection(url, user, password);
        //获取预处理状态参数
        String sql = "insert into emp values(?,?,?)";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,"good");
        pre.setString(2,"haha");
        pre.setString(3,"ouha");
        //执行操作
        int i = pre.executeUpdate();//返回值是操作成功的行数
        //如果我们执行的是查询的操作，那么可以使用executeQuery方法

    }

    public void secondGetConn() throws Exception {
        //获取配置参数信息
        Properties pro = new Properties();
        pro.load(DaoForAll.class.getClassLoader().getResourceAsStream("text.properties"));
        //通过配置信息创建连接池对象。
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        //通过连接池对象获取链接
        Connection conn = dataSource.getConnection();
        String sql = "update emp set username = ? where username=?";
        //获取状态参数
        PreparedStatement pres = conn.prepareStatement(sql);
        //通过状态参数为动态参数赋值。
        pres.setString(1,"hello");
        pres.setString(2,"world");
        int i = pres.executeUpdate();//返回值是执行成功的行数。
    }

    public <T>List<T> getConn(String sql,Class clazz,Object... params) {
        Connection conn = null;
        List<T> query = null;
        try {
            conn = JDBCUtil.getConn();
            query = qr.query(conn,sql,new BeanListHandler<T>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return query;
    }

    public <T> T selectOne(String sql,Class clazz,Object... params){
        Connection conn = null;
        T obj = null;
        conn = JDBCUtil.getConn();
        try {
            obj = qr.query(conn, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public int update(String sql,Object... params){
        Connection conn = null;
        int update= 0;
        try {
            update = qr.update(conn,sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConn(null,null,conn);
        }
        return update;
    }
}
