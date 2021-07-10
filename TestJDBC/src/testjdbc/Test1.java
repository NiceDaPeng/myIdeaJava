package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {

    public static void main(String[] args) {
        //1,导包
        //2,加载驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //3，获取链接
            String url="jdbc:mysql://localhost:3306/test";
            String user="root";
            String password="admin";
            Connection conn = DriverManager.getConnection(url, user, password);
            //4，获取状态参数
            Statement statement = conn.createStatement();
            //5,执行sql语句
            String sql = "update emp set job ='manager' where empno=9999";
            statement.executeUpdate(sql);
            System.out.println("操作成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
