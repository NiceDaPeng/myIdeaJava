package com.dpj.dynamic;

import com.dpj.domain.User;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class UserServiceImpl implements UserService {


    @Override
    public void regist(User user) {
        System.out.println("user = " + user);
    }

    @Override
    public void login(String name, String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
    }
}
