package jdbcutils3;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnectionOfDataSource {
    private static ThreadLocal th = null ;
    private static Connection conn = null;
    private static DataSource ds = null;
    private static Properties pro = null;

    static{
        try {
            pro.load(GetConnectionOfDataSource.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
            conn = ds.getConnection();
            th = new ThreadLocal();
            th.set(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws Exception {
        if (th == null){
            conn = ds.getConnection();
        } else {
            Connection conn = (Connection) th.get();
        }
        return conn;
    }

    public static void closeConn(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
