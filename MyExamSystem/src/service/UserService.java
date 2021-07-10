package service;

import bean.User;
import dao.UserDao;

public class UserService {


    public String checkMessge(String account,String password){

        User user = UserDao.selectOne(account);
        if (user != null && user.getPassword().equals(password)){
            return "登录成功";
        }
        return "账号密码错误";
    }
}
