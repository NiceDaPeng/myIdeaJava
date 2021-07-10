package testmain;

import dao.JDBCUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test3 {

    public static void main(String[] args) {

        Connection conn = JDBCUtils.getConn();
        try {
            String sql = "update student set photo=? where sid=1";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setBinaryStream(1,new FileInputStream("image/洋娃娃.jpg"));
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
