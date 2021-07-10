package testpreparement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPrepareStatement {

    public static void main(String[] args) {

        String className="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password="admin";
        String sql = "insert into emp(empno,ename) values(9892,'haha')";
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
