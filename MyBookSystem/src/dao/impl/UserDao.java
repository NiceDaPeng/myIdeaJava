package dao.impl;

import dao.BaseDao;
import dao.DaoInterface;
import domain.User;

public class UserDao extends BaseDao implements DaoInterface {

    //设计一个方法用来读取User的用户名和密码
    public User login(String uname){
        String sql = "select uname,upassword from user where uname= ?";
        User user = queryOne(sql, User.class, uname);
        return user;
    }


}
