package com.dpj.arraylist.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

    private static Connection conn;
    static {
        Properties pro = new Properties();
        try {
            //加载配置参数
            pro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            DataSource ds  = DruidDataSourceFactory.createDataSource(pro);
            conn = ds.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        return conn;
    }

    public static void close(ResultSet set, Statement statement,Connection conn){
        try {
            if (set != null){
                set.close();
            }
            if (statement != null){
                statement.close();
            }

            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
