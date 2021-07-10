package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();
    //注册用户
    @Override
    public void registUser(User user) {
        dao.saveUser(user);
    }

    //登录用户
    @Override
    public User login(User user) {
        return dao.queryUserByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    //判断用户是否存在
    @Override
    public boolean existsUser(String username) {

        User user = dao.queryUserByUserName(username);
        if (user == null){
            //没查到表示可用
            return false;
        }
        //查到了表示不可用
        return true;
    }
}
