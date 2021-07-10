package dao.impl;

import dao.BaseDao;
import domain.User;

public class UserDao extends BaseDao {

    public User login(String uname){
        String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM ATM WHERE ANAME=?";
        User user = queryOne(sql, User.class,uname);
        return user;
    }
}
