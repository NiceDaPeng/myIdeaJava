package com.dpj.dao;

import com.dpj.domain.City;
import com.dpj.domain.Country;

import java.sql.*;
import java.util.ArrayList;

public class CityDao {

    public ArrayList<City> queryCityByCid(Integer aid){

        ArrayList<City> cities = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/world";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "admin";
        String sql = "SELECT CITYID,CITYNAME,CITYSIZE,AID FROM CITY WHERE AID=?";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement psta = conn.prepareStatement(sql);
            psta.setInt(1,aid);
            ResultSet set = psta.executeQuery();
            while (set.next()){
                City city = new City(set.getInt("cityid"),set.getString("cityname"),set.getInt("citysize"),set.getInt("aid"));
                cities.add(city);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

}
