package com.dpj.staticfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StaticFactoryBean {

    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmybatis?useSSL=false&characterEncoding=utf-8","root","admin");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
