package dao;

import domain.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {

    //查询所有用户名
    public User queryAllId(String uname){
        ArrayList<User> userList = new ArrayList<>();
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/booksystem";
        String username = "root";
        String password = "admin";
        User user = null;
        String sql = "SELECT UNAME,UPASSWORD FROM USER WHERE UNAME = ?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement psta = conn.prepareStatement(sql);
            psta.setString(1,uname);
            ResultSet set = psta.executeQuery();
            if (set.next()){
                user = new User(set.getString("uname"),set.getString("upassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}
