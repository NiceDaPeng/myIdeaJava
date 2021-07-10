package com.dpj.service;

import com.dpj.domain.User;

public interface UserService {

    void login(String name,String password);
    void regist(User user);
}
