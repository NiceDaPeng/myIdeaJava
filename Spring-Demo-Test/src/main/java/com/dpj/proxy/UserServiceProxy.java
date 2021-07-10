package com.dpj.proxy;

import com.dpj.domain.User;

public class UserServiceProxy implements UserService{
    private UserService service = new UserServiceImpl();
    @Override
    public void regist(User user) {
        System.out.println("UserServiceProxy.regist  代理类的regist");
        service.regist(new User());
    }

    @Override
    public void login(String name, String password) {
        System.out.println("UserServiceProxy.login  代理类的login");
        service.login("linghuchong","aaaaaa");
    }
}
