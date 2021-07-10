package test;

import dao.EmpDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {

        EmpDao dao = new EmpDao();
        ArrayList<HashMap<String, Object>> message = dao.getMessage();
        for (HashMap<String,Object> map:
             message) {
            System.out.println(map.get("deptno")+"-"+map.get("count"));
        }
    }
}
