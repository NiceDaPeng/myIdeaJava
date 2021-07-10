package com.dpj.dao;

import com.dpj.domain.Country;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class CountryDao {


    public ArrayList<Country> queryAllCountry(){

        ArrayList<Country> countries = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/world";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "admin";
        String sql = "SELECT CID,CNAME FROM COUNTRY";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement psta = conn.prepareStatement(sql);
            ResultSet set = psta.executeQuery();
            while (set.next())
            {
                Country country = new Country(set.getInt("cid"),set.getString("cname"));
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
