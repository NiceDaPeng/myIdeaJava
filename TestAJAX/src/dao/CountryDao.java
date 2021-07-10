package dao;

import domain.User;
import util.ThreadLocalManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDao {

    //负责查询单条记录
    public List queryOne(String uname){

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "admin";
        User user = null;
        ArrayList<String> list = new ArrayList<>();
        try {

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            String sql = "SELECT CNAME FROM COUNTRY";
            PreparedStatement psta = conn.prepareStatement(sql);
            ResultSet set = psta.executeQuery();
            while (set.next()){
               String cname = set.getString("cname");
               list.add(cname);
            }

            ThreadLocal local = ThreadLocalManager.getLocal("list");
            local.set(list);

            set.close();
            psta.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
