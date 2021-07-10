package testjdbc;

import java.sql.*;

public class Test02 {

    public static void main(String[] args) {

        /*
        *
        * 注册驱动的三部曲
        * 1，导入jar包
        * 2，加载jar包到buildpath中
        * 3，加载驱动类
        * */

        //加载驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接并获取连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","123456");
            //编写sql
            String sql ="insert into department values(?,?,?)";
            //获取PrepareStatement对象
//            PreparedStatement pre = conn.prepareStatement(sql);
//            pre.setObject(1,null);
//            pre.setObject(2,"管理工程系");
//            pre.setObject(3,"连锁经营管理等专业");
//            int num = pre.executeUpdate();
//            System.out.println(num > 0? "添加成功":"添加失败");
            String sql1 = "delete from department where depNo = 606";
            PreparedStatement pre1 = conn.prepareStatement(sql1);
            int set = pre1.executeUpdate();
            String sql2 = "select * from department";
            PreparedStatement pre = conn.prepareStatement(sql2);
            ResultSet set1 = pre.executeQuery();
            while (set1.next()){
                System.out.println(set1.getString("depNo")+set1.getString("depName")+set1.getString("depNote"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
