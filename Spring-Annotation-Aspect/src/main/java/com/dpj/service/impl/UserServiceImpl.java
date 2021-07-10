package com.dpj.service.impl;

import com.dpj.domain.User;
import com.dpj.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserServiceImpl implements UserService, ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
    @Override
    public void login(String name, String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        UserService userService = (UserService) ctx.getBean("userService");
        userService.regist(new User());
    }

    @Override
    public void regist(User user) {
        System.out.println("user = " + user);
    }


}
