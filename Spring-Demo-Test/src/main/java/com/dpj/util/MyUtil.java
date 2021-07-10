package com.dpj.util;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyUtil implements FactoryBean<Connection> {


    @Override
    public Connection getObject() throws Exception {
        String url = "jdbc:mysql://localhost:3306/testmybatis?useSSL=false&characterEncoding=utf-8";
        String driverClassName="com.mysql.jdbc.Driver";
        String user="root";
        String password = "admin";
        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    @Override
    public Class<Connection> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

}
