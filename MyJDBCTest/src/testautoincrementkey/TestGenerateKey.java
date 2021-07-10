package testautoincrementkey;

import java.sql.*;

public class TestGenerateKey {

    //适应prepareStatement添加数据时，获取自增长键值
    /*
    * 例如：购物时，结算时，会产生新订单，会返回新订单的编号，而订单编号一般时随机生成的，保证订单编号的唯一性。
    *   在添加一个部门后，立刻返回这个部门的新的编号，而这个编号时自增长的。
    *   如何去完成？
    * 如何在PreparedStatement对象在执行完sql以后待会自增长的键值呢？  分为两部
    * 1,在创建PreparedStatement对象的时候，就指明需要返回自增长键值，否则mysql不会返回
    *   在Statement接口中声明了几个常量，
    * PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    * 2,拿到返回的结果集 ResultSet rs = pre.getGeneratedKeys();获取自增长的键值。不要调用getResultSet（）获取结果集
    * 而是通过getGenaratedKeys（）
    *
    * */

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/school";
            Connection conn = DriverManager.getConnection(url, "root", "123456");
            //编写sql语句
            String sql  = "insert into department values(null,?,?)";
            //创建PreparedStatement对象
            PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pre.setString(1,"花钱部门");
            pre.setString(2,"XXXX");
            int num = pre.executeUpdate();
            ResultSet rs = pre.getGeneratedKeys();//此时结果集里面包含两项，一个是操作成功的记录数，一个是自增长的键值
            if (rs.next()){
                System.out.println("新的部门的编号是："+rs.getObject(1));
            }

            System.out.println(num>0?"添加成功":"添加失败");
            rs.close();
            pre.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
