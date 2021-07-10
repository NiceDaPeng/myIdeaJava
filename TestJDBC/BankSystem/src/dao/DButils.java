package dao;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DButils {

    private static Connection conn = null;
    private static Statement sta = null;

    static {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取链接
            String url = "jdbc:mysql://localhost:3306/banksystem";
            String user = "root";
            String password = "admin";
            conn = DriverManager.getConnection(url, user, password);
            sta = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //设计一个方法用来执行修改操作操作

    /**
     * @param sql 要执行的sql语句
     * @return 执行成功则返回成功的行数，执行失败则返回-1
     */
    public static int updateData(String sql) {
        int len = 0;
        try {
            len = sta.executeUpdate(sql);
            return len;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //设计一个方法用来执行查询操作

    /**
     * @param sql 要执行的查询语句
     * @return 将一个用户的信息封装成一个map集合返回。
     */
    public static Map<String, Object> queryData(String sql) {
        Map<String, Object> map = new HashMap<>();
        try {
            ResultSet resultSet = sta.executeQuery(sql);
            while (resultSet.next()) {
                int cid = resultSet.getInt("cid");
                String cname = resultSet.getString("cname");
                float cbalance = resultSet.getFloat("cbalance");
                map.put("cid", cid);
                map.put("cname", cname);
                map.put("cbalance", cbalance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 用来关闭流
     */
    public static void closeConn() {
        try {
            DButils.sta.close();
            DButils.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //设计一个方法用来获取数据库中的用户名信息和密码

    /**
     *
     * @param num  登录的账户
     * @return  将登录的用户名和密码封装到一个Map集合中。
     * @throws SQLException
     */
    public static Map<String, String> getMessage(String num) throws SQLException {
        Map<String, String> map = new HashMap<>();

        String sql = "select * from users where cid=20210504 and cpassword='"+666666+"'";
        ResultSet resultSet = sta.executeQuery(sql);
        if (resultSet.next()) {
            String cno = resultSet.getString("cno");
            String cpassword = resultSet.getString("cpassword");
            map.put(cno, cpassword);
        }
        return map;
    }

    /**
     *
     * @param uno 根据账户获取用户名
     * @return 将用户名返回 如果用户名不存在则返回null
     * @throws SQLException
     */
    public static String getUserName(String uno) throws SQLException {
        String sql="select cname from users where cno="+Integer.parseInt(uno);
        ResultSet resultSet = sta.executeQuery(sql);
        if (resultSet.next()){
            String uname=resultSet.getString("cname");
            return uname;
        }
        return null;
    }
}
