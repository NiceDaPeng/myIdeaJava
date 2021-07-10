package dao;

import domain.User;

import java.sql.*;

public class UserDao {

        //负责查询单条记录
        public User queryOne(String uname){

            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/booksystem";
            String username = "root";
            String password = "admin";
            User user = null;

            try {
                Class.forName(driver);
                Connection conn = DriverManager.getConnection(url,username,password);
                String sql = "SELECT UNAME,UPASSWORD FROM USER WHERE UNAME=?";
                PreparedStatement psta = conn.prepareStatement(sql);
                psta.setString(1,uname);
                ResultSet set = psta.executeQuery();
                if (set.next()){
                    user = new User(set.getString("uname"),set.getString("upassword"));
                }

                set.close();
                psta.close();
                conn.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
        }
}
