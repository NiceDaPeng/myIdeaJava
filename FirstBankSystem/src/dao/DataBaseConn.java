package dao;

import domain.Customer;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DataBaseConn {

    private static Connection conn = null;
    private static Statement statement = null;

    //创建链接
    //1,导包
    static {
        try {
            //2，加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //3,获取链接
            String url = "jdbc:mysql://localhost:3306/banksystem";
            String user = "root";
            String password="admin";
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //设计一个方法用来执行一个sql查询操作

    /**
     *
     * @param userid  要查询的用户名
     * @throws SQLException
     */
    public Customer queryOneData(String userid) throws SQLException {

        String sql = "select cid,cname,cpassword,cbalance from users where cid=?";
        PreparedStatement presta = conn.prepareStatement(sql);
        presta.setString(1,userid);
        ResultSet resultSet = presta.executeQuery();
        Customer customer = null;
        if (resultSet.next()){
            String cid = resultSet.getString("cid");
            String cname=resultSet.getString("cname");
            Float cbanlance=resultSet.getFloat("cbalance");
            String password = resultSet.getString("cpassword");
            customer = new Customer(cid,cname,password,cbanlance);
        }
        return customer;
    }

    /**
     * 设计一个方法用来执行修改，删除，和插入操作
     * @param customer 要执行的需要更改信息用户
     * @return 如果返回值大于0 则说明执行成功
     * @throws SQLException
     */
    public void updateData(Customer customer) throws SQLException {
        String sql = "update users set cpassword=?,cbalance = ?where cid =?";
        PreparedStatement presta = conn.prepareStatement(sql);
        presta.setString(1,customer.getPassword());
        presta.setFloat(2,customer.getBalance());
        presta.setString(3,customer.getUserid());
        int value = presta.executeUpdate();
    }

    public void insertData(Customer customer) throws SQLException {
        String sql = "insert into users values(?,?,?,?)";
        PreparedStatement presta = conn.prepareStatement(sql);
        presta.setString(1,customer.getUserid());
        presta.setString(2,customer.getUserName());
        presta.setString(3,customer.getPassword());
        presta.setFloat(4,customer.getBalance());
        presta.executeUpdate();
    }

    //设计一个方法用来关闭链接
    public void closeConn(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }













}
