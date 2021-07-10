package com.dpj.test;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = ("jdbc:mysql://localhost:3306/day02_library");
            Connection conn = DriverManager.getConnection(url, "root", "123456");
//            String sql = "insert into student values("null,?,?");
//            conn.prepareStatement();
        }  catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void test(){

    }
}
