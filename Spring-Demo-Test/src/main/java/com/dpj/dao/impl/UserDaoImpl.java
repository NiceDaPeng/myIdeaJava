package com.dpj.dao.impl;

import com.dpj.dao.UserDao;
import com.dpj.domain.User;

public class UserDaoImpl implements UserDao {

    @Override
    public void insert(User user) {
        System.out.println("UserDaoImpl.insert   + user");
    }

    @Override
    public void login(String name, String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
    }
}
