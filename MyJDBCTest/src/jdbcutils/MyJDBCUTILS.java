package jdbcutils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MyJDBCUTILS {

    public static void main(String[] args) {


        try {
            Connection conn = Test.getConn();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
