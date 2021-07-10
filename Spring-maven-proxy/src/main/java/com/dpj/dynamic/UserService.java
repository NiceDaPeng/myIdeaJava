package com.dpj.dynamic;

import com.dpj.proxy.User;

public interface UserService {

    void login(String username,String password);

    void regist(User user);
}
