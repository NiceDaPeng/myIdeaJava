import com.dpj.domain.User;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class TestMain {

    private static Integer age;

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

//       String str = null;
//       str.concat("abc");
//       str.concat("def");
//        System.out.println("str = " + str);

//        String s = "dpj";
//        String k = s+t;
//        String t = "is good";
//        TestMain tm = new TestMain();
//        StringBuffer sb = new StringBuffer("abcd");
//        tm.changeString(sb);
//        System.out.println(sb);

//        Set<String> set = new HashSet<>();
//        set.add("good");
//        Iterator<String> iterator = set.iterator();
//        System.out.println(iterator.hasNext());

//        List list = new ArrayList<>();
//        list.
//        HashMap map = new HashMap();
//        map.put("name",null);
//        map.put("name","jack");
//        System.out.println(map.get("name"));
//        List<Integer> list = new ArrayList();
//        for (int i = 0; i < 5; i++) {
//            list.add(i+1);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            list.remove(i);
//        }
//        System.out.println(list);

//        try {
//            one();
//            System.out.println("A");
//        } catch (Exception e) {
//            System.out.println("C");
//        }

//        try {
//            Class<?> clazz = Class.forName("com.dpj.domain.User");
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        String url = "jdbc:mysql://localhost:3306/testmybatis?characterEncoding=utf-8";
        String driverClassName="com.mysql.jdbc.Driver";
        String username = " root ";
        String password = " admin ";
        User user = new User();
        user.setUname("dpj");
        user.setUpassword("aaa");
//        String sql = " insert into student(uname,upassword) values("+user.getUname()+","+user.getUpassword()+")";
        String sql = "select * from student where sname='zzt'";
        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1,"good");
//        ResultSet resultSet = ps.executeQuery();
//        while (resultSet.next()){
//           resultSet.
//        }

        

    }




}
