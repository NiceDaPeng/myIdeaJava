package com.dpj.cglib;

import com.dpj.proxy.User;

public class UserService {
    public void regist(User user){
        System.out.println("UserService.regist");
    }

    public void login(String username,String password){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }

}
