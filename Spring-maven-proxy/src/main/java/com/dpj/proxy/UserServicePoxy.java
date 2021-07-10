package com.dpj.proxy;

public class UserServicePoxy implements UserService{

    private UserServiceImpl userService = new UserServiceImpl();
    @Override
    public void regists(User user) {
        System.out.println("UserServicePoxy--log----.regists");
        userService.regists(user);
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("----log-----");
        return userService.login(username,password);
    }
}
