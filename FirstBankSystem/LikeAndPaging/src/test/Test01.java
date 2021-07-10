package test;

import domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test01 {

    public ArrayList<Emp> test(int page) throws ClassNotFoundException, SQLException {
        ArrayList<Emp> list = new ArrayList<>();
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useSSL=true";
        String user = "root";
        String password = "admin";
        Class.forName(className);
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM EMP ORDER BY SAL DESC LIMIT ?,5";
        PreparedStatement presta = conn.prepareStatement(sql);
        presta.setInt(1,page);
        ResultSet resultSet = presta.executeQuery();
        while (resultSet.next()){
            Emp emp = new Emp();
            int empno = resultSet.getInt("empno");
            String ename = resultSet.getString("ename");
            emp.setEmpno(empno);
            emp.setEname(ename);
            list.add(emp);
        }
        return  list;
    }

    public static void main(String[] args) {

        System.out.println("请输入你要查询的页数");
        Scanner input = new Scanner(System.in);
        int page = input.nextInt();
        Test01 test01 = new Test01();
        ArrayList<Emp> test = null;
        try {
            test = test01.test((page - 1) * 5);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Emp emp:test){
            System.out.println(emp);
        }
    }
}
