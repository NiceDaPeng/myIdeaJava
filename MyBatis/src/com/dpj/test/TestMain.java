package com.dpj.test;

import com.dpj.dao.UserDao;
import com.dpj.domain.User;

import java.util.List;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {

//        UserDao dao = new UserDao();
//        User user = dao.selectOne("zhangsan");
//        System.out.println("-----------");
//        user.setUpassword("888");
//        System.out.println(user);
//        int update = dao.update(user);
//        System.out.println(user);
        UserDao dao = new UserDao();
        List<User> userList = dao.selectByOrder("asc");
        for (User user :
                userList) {
            System.out.println(user);
        }

//        List<User> users = dao.selectAll();
//        System.out.println(users);

//        int count = dao.selecCount();
//        System.out.println(count);
//        List<Map<String, Object>> maps = dao.selectScalar();
//        for (Map<String, Object> map:
//        maps){
//            System.out.println(map);
//        }

    }
}
