package com.dpj.proxy;

public class UserServiceImpl implements UserService{
    @Override
    public void regists(User user) {
        System.out.println("UserServiceImpl.regists");
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
