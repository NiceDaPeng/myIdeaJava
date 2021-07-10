package com.dpj.instanceFactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InstanceFactory {

    public Connection getConn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useSSL=false","root","admin");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
