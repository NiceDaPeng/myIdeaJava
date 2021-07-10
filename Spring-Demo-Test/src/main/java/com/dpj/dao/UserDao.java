package com.dpj.dao;

import com.dpj.domain.User;

public interface UserDao {

    void insert(User user);

    void login(String name,String password);
}
