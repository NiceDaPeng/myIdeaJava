package com.dpj.dynamic;

import com.dpj.proxy.User;

public class UserServiceImpl implements UserService{

    @Override
    public void login(String username, String password) {
        System.out.println("UserServiceImpl.login");
    }

    @Override
    public void regist(User user) {
        System.out.println("UserServiceImpl.regist");
    }
}
