package com.dpj.dao;

import com.dpj.domain.Area;
import com.dpj.domain.Country;

import java.sql.*;
import java.util.ArrayList;

public class AreaDao {

    public ArrayList<Area> queryAreaByCid(String cid) {

        ArrayList<Area> areas = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/world";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "admin";
        String sql = "SELECT AID,ANAME,CID FROM AREA WHERE CID = ?";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement psta = conn.prepareStatement(sql);
            psta.setInt(1,Integer.parseInt(cid));
            ResultSet set = psta.executeQuery();
            while (set.next())
            {
                Area area = new Area(set.getInt("aid"),set.getString("aname"),set.getInt("cid"));
                areas.add(area);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areas;
    }
}
