package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpDao {
    private static Connection conn = null;
    static {
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useSSL=true";
        String user = "root";
        String password = "admin";
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HashMap<String,Object>> getMessage(){
        ArrayList<HashMap<String,Object>> list = new ArrayList<>();

        String sql = "select deptno,count(empno) as ct from emp e group by deptno";
        try {
            PreparedStatement prestat = conn.prepareStatement(sql);
            ResultSet rs = prestat.executeQuery();
            while (rs.next()){
                HashMap<String,Object> map = new HashMap<>();
                int deptno = rs.getInt("deptno");
                int count = rs.getInt("ct");
                map.put("deptno",deptno);
                map.put("count",count);
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
