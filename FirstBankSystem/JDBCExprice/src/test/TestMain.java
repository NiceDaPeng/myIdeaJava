package test;

import dao.WorldDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestMain {

    public static void main(String[] args) throws SQLException {

        WorldDAO wd = new WorldDAO();
        ArrayList<HashMap<String, Object>> mess = wd.getMessageFormTables();
        for (HashMap<String, Object> map:
        mess){
            System.out.println(map.get("name"));
        }
    }
}
