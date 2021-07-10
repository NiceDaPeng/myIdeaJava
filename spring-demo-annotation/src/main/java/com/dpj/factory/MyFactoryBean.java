package com.dpj.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@PropertySource("classpath:db.properties")
public class MyFactoryBean {
    @Value("${url}")
    private String url;

    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${user}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){

        return new JdbcTemplate(dataSource);
    }

    @Bean

    public DataSource getDataSource(){
        DriverManagerDataSource ddm = new DriverManagerDataSource();
        ddm.setUrl(url);
        ddm.setDriverClassName(driverClassName);
        ddm.setUsername(username);
        ddm.setPassword(password);
        return ddm;
    }
}
