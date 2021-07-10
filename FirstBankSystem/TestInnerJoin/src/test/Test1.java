package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test1 {

    public static void main(String[] args) {

        String className = "com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/emp";
        String user = "root";
        String password = "admin";
        try {
            Class.forName(className);
            Connection connection = DriverManager.getConnection(url,user,password);
            String sql ="insert into users(empno,ename) values(9999,'haha')";
            PreparedStatement presta = connection.prepareStatement(sql);
            presta.executeUpdate();
            System.out.println("操作成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
