package com.dpj.proxy;

import com.dpj.domain.User;

public class UserServiceImpl implements UserService{

    @Override
    public void regist(User user) {
        System.out.println("UserServiceImpl.regist  原始类的regist");
    }

    @Override
    public void login(String name, String password) {
        System.out.println("UserServiceImpl.login  原始类的login");
    }
}
