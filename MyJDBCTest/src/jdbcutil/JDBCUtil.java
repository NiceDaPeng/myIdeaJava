package jdbcutil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static Connection conn = null;
    private static DataSource ds = null;
    static {
        try {
            Properties pro = new Properties();
            pro.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
            conn = ds.getConnection();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }
    public static void free(Connection con){
        try {
            if (con != null)
            con.close();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public static int update(Connection con,String sql, Object... args){
        int len = 0;
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            if (args != null && args.length > 0){
                for (int i = 0;i < args.length;i++){
                    pre.setObject(i+1,args[i]);
                }
            }
            len = pre.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return len;

    }
}
