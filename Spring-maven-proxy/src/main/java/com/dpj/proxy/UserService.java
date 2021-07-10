package com.dpj.proxy;

public interface UserService {

    /**
     *
     * @param user
     */
    void regists(User user);

    boolean login(String username,String password);
}
