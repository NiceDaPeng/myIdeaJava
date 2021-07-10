package com.dpj.service.impl;

import com.dpj.dao.impl.UserDaoImpl;
import com.dpj.pojo.User;
import com.dpj.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userimpl = new UserDaoImpl();
    @Override
    public boolean verfify(String code) {
        if (code.equals("abcde")){
            return true;
        }
        return false;
    }

    @Override
    public boolean login(String username, String passwrod) {
        User user = userimpl.queryUserByUserNameAndPassword(username, passwrod);
        if (user != null){
            System.out.println("");
        }
        return false;
    }

    @Override
    public boolean regist(User user) {
        return false;
    }
}
