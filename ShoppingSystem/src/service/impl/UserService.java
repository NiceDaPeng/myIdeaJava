package service.impl;

import dao.impl.UserDao;
import domain.User;
import service.Service;

import java.net.ServerSocket;

public class UserService implements Service {
    private UserDao dao = new UserDao();

    //登录
    public boolean login(String uname,String password){
        User user = dao.selectOneUser(uname);
        if (user != null && user.getUpassword().equals(password)){
            return true;
        }
        return false;
    }
}
