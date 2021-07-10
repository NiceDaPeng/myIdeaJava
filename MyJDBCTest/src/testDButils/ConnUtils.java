package testDButils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnUtils {

    private static Connection con = null;
    private static ThreadLocal threadLocal = null;
    private static DataSource ds = null;
    static {
        Properties pro = new Properties();
        try {
            pro.load(ConnUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
            con = ds.getConnection();
            threadLocal = new ThreadLocal();
            threadLocal.set(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() throws SQLException {
         if (con == null){
             con = ds.getConnection();
         } else {
             con = ds.getConnection();
         }
         return con;
    }
}
