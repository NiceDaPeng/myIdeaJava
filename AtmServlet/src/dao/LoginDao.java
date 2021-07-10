package dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import domain.Atm;

import java.sql.*;

public class LoginDao {

    public Atm selectOne(String aname, String apassword){

        String driver="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/atm";
        String user="root";
        String password="admin";
        Atm atm = new Atm();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            String sql = "select * from atm where aname=?";
            PreparedStatement presta = conn.prepareStatement(sql);
            presta.setString(1,aname);
            ResultSet set = presta.executeQuery();
            while (set.next()){
                atm.setAname(set.getString("aname"));
                atm.setApassword(set.getString("apassword"));
                atm.setAbalance(set.getFloat("abalance"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atm;
    }
}
