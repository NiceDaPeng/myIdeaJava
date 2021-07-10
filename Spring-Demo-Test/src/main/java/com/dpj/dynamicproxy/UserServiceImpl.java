package com.dpj.dynamicproxy;

import com.dpj.domain.User;

public class UserServiceImpl implements UserService{
    @Override
    public void regist(User user) {
        System.out.println("UserServiceImpl.regist");
    }

    @Override
    public void login(String name, String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
    }
}
