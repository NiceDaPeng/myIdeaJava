package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

    public static void main(String[] args) {

        //Java链接数据库的6步曲
        //1，导包，就是将数据库放的jdbc实现的包导入到当前工程下
        //2,加载驱动类，将导入的包里的驱动加载到当前工程下
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //3,获取链接
            String url="jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password="admin";
            Connection conn = DriverManager.getConnection(url, user, password);
            //4,获取状态参数 创建流
            Statement stat = conn.createStatement();
            //5,执行sql语句
            String sql = "insert into emp(empno,ename) values(9999,'dpj')";
            stat.executeUpdate(sql);
            System.out.println("操作成功");
            //6,关闭流
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
