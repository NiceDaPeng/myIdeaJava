package jdbcutil2;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class Test2 {

    public static void main(String[] args) throws Exception {

        Properties pro = new Properties();
        pro.load(new FileInputStream("src//druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        conn.setAutoCommit(false);
        String sql = "insert into user values(?,?,?)";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setObject(1,123);
        pre.setObject(2,"helloworld");
        pre.setObject(3,"do anything");
        pre.addBatch();
        try{
            int[] ints = pre.executeBatch();
            if (ints != null && ints.length >0){
                conn.commit();
            }else {
                conn.rollback();
            }
        } catch (Exception e){
            conn.rollback();
        }
    }
}
