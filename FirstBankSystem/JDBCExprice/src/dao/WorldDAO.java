package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class WorldDAO {

    private static String className = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/world?useSSL=true";
    private static String user = "root";
    private static String password = "admin";
    private static Connection conn = null;

    static {
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HashMap<String, Object>> getMessageFormTables() throws SQLException {
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        String sql = "select c.cname from country c inner join area a on a.cid = c.cid inner join city ci on ci.aid=a.aid where cityname='哈尔滨';";
        PreparedStatement prestat = conn.prepareStatement(sql);
        ResultSet rs = prestat.executeQuery();
        while (rs.next()) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", rs.getString("cname"));
//            map.put("count", rs.getInt("ct"));
            list.add(map);
        }
        return list;
    }
}
