package configClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import sun.misc.Contended;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@PropertySource("classpath:test.properties")
public class ConfigClass {
    @Value("${url}")
    private String url;
    @Value("${driverClassName}")
    private String driver;
    @Value("user")
    private String username;
    @Value("password")
    private String password;


    //定义一个方法用来获取JdbcTemplate对象
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    //定义一个方法用来获取DataSource对象
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setDriverClassName(driver);
        dataSource.setPassword(password);
        return dataSource;

    }

}
