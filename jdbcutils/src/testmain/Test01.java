package testmain;

import dao.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {

    public static void main(String[] args) throws SQLException {

        Connection conn = JDBCUtils.getConn();

        String sql = "insert into test values(?,?)";
        PreparedStatement pre = conn.prepareStatement(sql);
        for (int i = 0; i < 49999; i++) {
            pre.setInt(1,i+6);
            pre.setString(2,"测试"+i);
            pre.addBatch();
            if (i % 1000 == 0)
            pre.executeBatch();
        }
    }
}
