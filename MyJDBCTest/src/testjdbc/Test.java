package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {

        /*
            JDBC常用的接口
            1，Connection  java.sql包下面和javax.sql链接用的
            2，Statement 和PreparedStatement:增删改查
            3，ResultSet：接收和处理查询结果
            辅助的类：
            DriverManager：驱动管理类，管理驱动的。
            JDBC程序的编写步骤
            1，注册驱动（如果这步不做，编译不会报错，但是运行会报找不到驱动类等异常，所以注册驱动一般先写
                注册驱动三部曲：1，讲jar包放在libs中，2讲jar包添加到buildpath中，3在代码中注册驱动
            2，链接驱动 DriverManager 和Connection
            3，操作数据库
                增删改用到的是Statement preparedStatement
                查，用到的是resultSet
            4，断开链接，关闭各种资源。
            url:统一资源定位符，通俗的讲就是网址。
                1用来定位到哪台电脑上
                2哪种DBMS服务，
                3访问哪个数据库
                4这个DBMS软件目前运行在哪个端口上。
                5链接这个DBMS软件是否还需要其它的参数。
            url的标准格式：协议：//主机名：端口号/资源路径
            链接mysql的url jdbc:mysql://主机名：端口号/数据库名/其它参数配置
            链接我这台电脑的写法：
                jdbc:mysql://localhost:3306/test
         */

        //链接数据库

        try {
            //1，注册驱动：目的 讲驱动类加载到内存并且初始化这个类。
            Class.forName("com.mysql.jdbc.Driver");
            //2,连接数据库
            String url = "jdbc:mysql://localhost:3306/day02_library";
            Connection conn = DriverManager.getConnection(url, "root", "123456");
            //3,操作数据库
            //添加一条记录到user表中
            //4,编写sql
            String sql = "insert into user values(3,'12345')";
            //5,准备一个statement Connection好比Socket statement好比InputStream和OutputStream
            Statement st = conn.createStatement();
            int num = st.executeUpdate(sql);//num是几行成功
            System.out.println(num>0?"添加成功":"添加失败");
            st.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
