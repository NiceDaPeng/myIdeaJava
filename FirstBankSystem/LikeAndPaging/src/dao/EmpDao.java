package dao;

import domain.Emp;

import java.sql.*;
import java.util.ArrayList;

public class EmpDao {

    //设计一个方法查询全部的emp表格记录

    private static String className="com.mysql.jdbc.Driver";
    private static String user = "root";
    private static String password="admin";
    private static String url="jdbc:mysql://localhost:3306/test?useSSL=true";
    private static Connection conn;
    static {
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Emp> limitPage(int rowIndex){
        ArrayList<Emp> list = new ArrayList<>();
        String sql = "select * from emp order by sal desc limit ?,5";
        PreparedStatement prestat = null;
        ResultSet rs = null;
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setInt(1,rowIndex);
            rs = prestat.executeQuery();
            while (rs.next()){
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getFloat("sal"));
                emp.setComm(rs.getFloat("comm"));
                emp.setDeptno(rs.getInt("deptno"));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (prestat != null){
                try {
                    prestat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
