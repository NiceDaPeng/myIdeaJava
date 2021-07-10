package com.dpj.proxy;

import com.dpj.domain.User;

public interface UserService {
    void regist(User user);
    void login(String name,String password);
}
