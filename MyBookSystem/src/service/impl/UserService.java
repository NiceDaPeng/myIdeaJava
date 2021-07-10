package service.impl;

import dao.impl.UserDao;
import domain.User;
import service.Service;

public class UserService implements Service {

    private UserDao dao = new UserDao();

    public boolean add(Object obj) {
        return false;
    }


    public boolean remove(Object obj) {
        return false;
    }


    public boolean set(Object obj) {
        return false;
    }


    public <T> T select(T obj) {
        return null;
    }

    /**
     * 普通用户登录验证
     * @param uname
     * @param upassword
     * @return
     */

    public boolean login(String uname,String upassword) {

        User user = dao.login(uname);
        if (user != null && user.getUpassword().equals(upassword)){
            return true;
        }
        return false;
    }
}
