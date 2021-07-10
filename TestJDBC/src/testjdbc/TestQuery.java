package testjdbc;

import java.sql.*;

public class TestQuery {

    public static void main(String[] args) {

        //导包
        //加载驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            new com.mysql.jdbc.Driver();
            //DriverManager.registerDriver(new Driver());
            //System.setProperty("jdbc.mysql","com.mysql.jdbc.Driver");
            //获取链接
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "admin";
            Connection conn = DriverManager.getConnection(url, user, password);

            //获取状态参数
            Statement sta = conn.createStatement();
            //执行操作
            String sql="select * from emp where empno=9999";
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()){
                int empno = rs.getInt("empno");
                String ename=rs.getString("ename");
                System.out.println(empno+"--"+ename);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
