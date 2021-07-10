package service.impl;

import dao.impl.UserDao;
import service.Service;

public class RegistService implements Service {

    //设计一个方法用来注册信息
    UserDao dao = new UserDao();
    public boolean regist(String userName,String password){
        return dao.regist(userName, password);
    }

}
