package service;

import dao.BaseDao;
import dao.impl.UserDao;
import domain.User;
import util.ThreadLocalManager;

public class UserService {


    private UserDao dao  = new UserDao();
    public String login(String uname,String password){
        User user = dao.login(uname);
        if (user != null && user.getApassword().equals(password)){
            ThreadLocal local = ThreadLocalManager.getLocal(uname);
            local.set(user);
            return "登录成功";
        }
        return "账号或密码错误";
    }
}
