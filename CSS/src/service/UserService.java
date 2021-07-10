package service;

import dao.UserDao;
import domain.User;

import java.util.ArrayList;

public class UserService {

    private UserDao dao = new UserDao();
    //判断是否存在
    public String query(String uname){

        User user = dao.queryAllId(uname);
        if (user == null){
            return "账户不存在";
        }
        return "请输入密码";
    }
}
