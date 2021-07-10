package testjdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {

//       try {
//            //1,将jar包导入到libs中 2，将jar包添加到buildpath中，3，注册驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/day02_library";
//            //2,创建连接
//            Connection conn = DriverManager.getConnection(url, "root", "123456");
//            //3,编写sql语句
//            String sql = "insert into user values('校长','123654')";
//            //4,准备一个statement
//            Statement st = conn.createStatement();
//            //5,执行sql
//            int num = st.executeUpdate(sql);
//            System.out.println(num > 0?"添加成功":"添加失败");
//            //6,关闭资源
//            st.close();
//            conn.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }

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
        //导入jar包，加载jar包，注册驱动
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            //连接数据库
//            String url = "jdbc:mysql://localhost:3306/day02_library";
//            Connection conn = DriverManager.getConnection(url, "root", "123456");
//            //编写sql
////            String sql = "insert into user values('黄蓉',password('98765'))";
//            String sql = "delete from user where username = 3";
//            //获取Statement
//            Statement state = conn.createStatement();
//            //执行sql
//            int num = state.executeUpdate(sql);//num的值是sql语句执行以后返回的操作成功的行数
//            System.out.println(num > 0?"操作成功":"操作失败");
//            state.close();
//            conn.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }

        // 导入jar包，加载jar包，注册驱动
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            //连接数据库
//            String url = "jdbc:mysql://localhost:3306/day02_library";
//            Connection conn = DriverManager.getConnection(url, "root", "123456");
//            //编写sql语句
//            String sql = "insert into user values('郭靖',password('13453'))";
//            //通过连接对象获取statement对象
//            Statement st = conn.createStatement();
//            //通过st执行sql语句
//            int num = st.executeUpdate(sql);
//            System.out.println(num > 0?"操作成功":"操作失败");
//
//            //关闭资源
//            st.close();
//            conn.close();
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }

        //导入jar包，添加jar包到buildpath中
        //加载驱动类
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            //连接数据库
//            String url = "jdbc:mysql://localhost:3306/day02_library";
//            Connection conn = DriverManager.getConnection(url, "root", "123456");
//            //编写sql
//            String sql = "select * from user";
//            Statement statement = conn.createStatement();
//            //增删改用的方法是executeUpdate(sql)
//            ResultSet set = statement.executeQuery(sql);
//            while(set.next()){
//                String sname = set.getString("username");
//                String password = set.getString("password");
//                System.out.println(sname+"\t\t"+password);
//            }
//            statement.close();
//            conn.close();
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        addTestSql();
    }


    public void getSqlResult(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            String url = "jdbc:mysql://localhost:3306/day02_library";
            Connection conn = DriverManager.getConnection(url, "root", "123456");
            //编写sql
            String sql = "select username,password from user";
            Statement statement = conn.createStatement();
            //增删改用的方法是executeUpdate(sql)
            ResultSet set = statement.executeQuery(sql);
            while(set.next()){
                //如果数据类型不太清楚可以使用getObject（）
                //如果清楚数据类型可以直接使用get数据类型（）
                String sname = set.getString(1);
                String password = set.getString(2);
                System.out.println(sname+"\t\t"+password);
            }
            statement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSql(){
        //从键盘输入人员的信息，添加到day02_library中的user表中
        //导入jar包 ，将jar包加载到buildpath中，加载驱动类
        //Statement拼接很多问题
        /*
        * 1，拼接比较麻烦
        * 2，sql注入问题
        * 3，无法使用blob等二进制类型的数据
        * 如何解决这些问题呢？
        * 使用Statement类的子类PrepareStatement
        * */
        try {
            Scanner input = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            String url = "jdbc:mysql://localhost:3306/day02_library";
            Connection conn = DriverManager.getConnection(url, "root", "123456");
            //编写sql语句
            System.out.println("请输入姓名");
            String inName = input.nextLine();
            System.out.println("请输入密码");
            String inPassword = input.nextLine();
            String sql = "insert into user values ('"+inName+"','"+inPassword+"')";
            //通过conn对象获取对应的Statement对象
            Statement st = conn.createStatement();
            int num = st.executeUpdate(sql);
            //关闭资源
            st.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addTestSql(){

        try {
            //导入jar包，加载jar包到buildpath中
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //创建连接
            String url = "jdbc:mysql://localhost:3306/day02_library";
            Connection conn = DriverManager.getConnection(url, "root", "123456");
            String sql = "INSERT INTO USER VALUES('黄岛主',?,?)";
            String desc = "E:\\images\\psc.jpg";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,"123456");
            pre.setObject(2,new FileInputStream(desc));
            int num = pre.executeUpdate();
            System.out.println(num > 0?"添加成功":"添加失败");
            pre.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
