package testmain;

import dao.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {


    public static void main(String[] args) {

        Connection conn = JDBCUtils.getConn();

        try {

            conn.setAutoCommit(false);
            String sql ="UPDATE ATM SET ABALANCE=? WHERE ANAME=?";
            String sql1 = "UPDATE ATM SET ABALANCE =? WHERE ANAME=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setFloat(1,12000);
            pre.setString(2,"lisi");
            int i = 1/0;
            pre.executeUpdate();
            PreparedStatement pre1 = conn.prepareStatement(sql1);
            pre1.setFloat(1,10000);
            pre1.setString(2,"wangwu");

            pre1.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
