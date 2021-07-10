package jdbcutils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Test {

    private static Connection getConnection(){
        Connection conn = null;
        try {
            Properties pro = new Properties();
            pro.load(new FileInputStream("src/druid.properties"));
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getConn(){
        return getConnection();
    }
}
