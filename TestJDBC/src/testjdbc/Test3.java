package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test3 {
    public static void main(String[] args) {

        //JDBC是Java写好的用于链接数据库的接口，所以，数据库厂商要想和Java保持链接就需要实现jdbc接口
        //简单来说就是有自己的实现类。所以我们在使用的时候要将这些实现类导入到我们的开发环境中
        //1，导包
        //2,导包了以后还不行，还要将其加载到我们的开发环境中,也就是加载驱动类,在我们只知道类名的情况下可以通过反射机制
        //来实现加载驱动类的情况。
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //3,获取链接,想要获取链接就要知道我们要链接哪个数据库，所以此时我们需要知道url和user还有password
            String url="jdbc:mysql://localhost:3306/test";
            String user="root";
            String password="admin";
            Connection conn = DriverManager.getConnection(url, user, password);
            //4,获取状态参数，也就是获取流，这样我们就可以从数据库中年读取和写入信息了
            Statement sta = conn.createStatement();
            //5，执行sql语句
            String sql="insert into emp(empno,ename) values(9999,'dpj')";
            int num = sta.executeUpdate(sql);//返回值是执行成功的行数
            if (num > 0){
                System.out.println("操作成功");
            } else {
                System.out.println("操作失败");
            }

            //关闭流
            sta.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
