package service;

import dao.UserDao;
import domain.User;

public class UserService {

    private UserDao dao = new UserDao();
    //监测名字是否存在
    public String checkName(String uname){

        User user = dao.queryOne(uname);
        if (user != null){
            return "账号已存在,请重新输入";
        }
        return "账号可用";
    }
}
