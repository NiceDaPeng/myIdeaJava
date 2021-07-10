package jdbcchulishiwu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

    //事务的批处理
    /*
    *
    * 需求：删除某个订单，
    *       1，删除订单表的记录
    *       2，删除订单明细表的记录
    *       如果在订单明细表建立外键，指定on delete cascade，那么订单明细表的记录会自动删除
    *       如果没有指定外键，那么就需要程序员就需要再编写相应的sql语句来删除明细表的信息。
    * 假设现在要删除某个订单
    *
    * jdbc如何处理事务
    * 1，获取连接后，使用连接获取PreparedStatement对象之前，设置当前连接为手动提交事务。
    * conn.setAutoCommit(false)--将自动提交关闭
    * 2，在执行成功时，提交 conn.commit(); 执行失败了，则回滚 conn.rollback();
    * 3,在关闭连接之前，把手动提交模式重新修改为自动提交模式，因为你获取的连接基本上是从数据库连接池中获取的连接
    * 这种连接是重复使用的。如果将其修改为手动提交了，然后没有还原，当将这个连接还给连接池时，
    * 这个连接可能会被其他人拿到，而它以为时自动提交的，然后操作完它的sql以后，没有commit，结果是没有生效。
    * setAutoCommit（true），放在连接关闭之前。
    * */

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "123456");
            conn.setAutoCommit(false);
            String sql1 = "delete from orders where b_id = ?";
            String sql2 = "delete from orderitems where b_id = ?";
            PreparedStatement pst1 = conn.prepareStatement(sql1);
            PreparedStatement pst2 = conn.prepareStatement(sql2);
            pst1.setObject(1,"123445");
            pst2.setObject(1,"4858503");
            boolean flag = true;
            try {
                int len1 = pst1.executeUpdate();
                int len2 = pst2.executeUpdate();
                if (len1 > 0 && len2> 0){
                    conn.commit();
                } else {
                    conn.rollback();
                }
            } catch (Exception e){
                conn.rollback();
            }

            pst1.close();
            pst2.close();
            conn.setAutoCommit(true);
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
