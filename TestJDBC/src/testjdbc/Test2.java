package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {

    public static void main(String[] args) {

        //1导包
        //2,加载驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //3,获取链接
            String url="jdbc:mysql://localhost:3306/test";
            String user="root";
            String password="admin";
            Connection conn = DriverManager.getConnection(url, user, password);
            //4,获取状态参数（流）
            Statement statement = conn.createStatement();
            //5,执行操作
            String sql="delete from emp where empno=9897;";
            statement.executeUpdate(sql);
            System.out.println("操作成功");
            //6,关闭流
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
