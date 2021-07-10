package testbatch;

import java.sql.*;

public class TestBatch {
    /*
     * 批处理：什么时候用到批处理？
     *   当要执行某条sql语句多次
     * 例如：
     *   1，批量添加测试数据
     *   2，当用户购买东西后，一个订单中有很多的商品，那么就会涉及到两个操作，
     *       1，在订单明细表中意味着要批量插入多条记录
     *       2，批量修改商品表的销量和库存量。
     *   3，如何实现批处理呢？
     *       例如批量添加测试数据，在department表中，添加一千条的测试数据。
     *       信息命名为：测试部门i，部门简介i  i 1-1000
     *      用批处理实现插入测试数据
     *      1， pre.addBatch();//添加到批处理中，将数据先攒着，相当于缓冲流一样。底层有一个缓冲区，先缓冲所有要执行的sql语句
     *      2， int[] ints = pre.executeBatch();//执行这组批处理，返回值为一个int类型的数组，存储的是成功的行数
     *      3，在url后面加一个配置参数rewriteBatchedStatements = true;
     *          string url = "jdbc:mysql://localhost:3306/school?rewriteBatchedStatements = true;
     *          如果url后面有两个以上的参数第一个用？ 连接 其余的用&连接。
     *     在批处理添加时使用values 不要使用values
     * */

    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/school?rewriteBatchedStatements = true";
            Connection conn = DriverManager.getConnection(url, "root", "123456");
            //编写sql语句
            String sql = "insert into department values(null,?,?)";
            //创建PreparedStatement对象
            PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 1; i <= 1000; i++) {
                pre.setString(1, "测试部门" + i);
                pre.setString(2, "测试简介" + i);
                pre.addBatch();//添加到批处理中，将数据先攒着，相当于缓冲流一样。底层有一个缓冲区，先缓冲所有要执行的sql语句
                //执行这组批处理，返回值为一个int类型的数组，存储的是成功的行数
//                pre.executeUpdate();
            }
            int[] ints = pre.executeBatch();

            pre.close();
            conn.close();
            long end = System.currentTimeMillis();
            System.out.println(end - start);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
