package testautoincrementkey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestGeneratedKey {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //加载驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/school?rewriteBatchedStatements = true";
            Connection conn = DriverManager.getConnection(url, "root", "123456");
            String sql = "insert into department values(null,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            for (int i= 0; i < 1000;i++) {
                pst.setString(1,"Money部"+i);
                pst.setString(2,"挣大钱"+i);
                pst.addBatch();
            }
            pst.executeBatch();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
