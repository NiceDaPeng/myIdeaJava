package jdbcutil2;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils2 {

    private static Connection conn = null;
    private static DataSource ds = null;
    private static ThreadLocal<Connection> ts;
    static {
        try {
            Properties pro = new Properties();
            pro.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
            ts = new ThreadLocal<Connection>();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        Connection conn = ts.get();
        if (conn == null){
            try {
                conn = ds.getConnection();
                ts.set(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }
    public static void free(Connection con){
        try {
            if (con == null)
                con.close();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public static int update(String sql,Object... args) throws SQLException {
        Connection conn = getConn();
        PreparedStatement pre = conn.prepareStatement(sql);
        if (args != null && args.length != 0){
            for (int i= 0;i < args.length;i++){
                pre.setObject(i+1,args[i]);
            }
        }
        int len = pre.executeUpdate();
        pre.close();
        return len;
    }
}
