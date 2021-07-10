package com.dpj.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class MyFactory implements FactoryBean<Connection> {


    @Override
    public Connection getObject() throws Exception {
        String url = "jdbc:mysql://localhost:3306/school?useSSL=false&characterEncoding=utf-8";
        String driverClassName="com.mysql.jdbc.Driver";
        String username="root";
        String password="admin";
        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
