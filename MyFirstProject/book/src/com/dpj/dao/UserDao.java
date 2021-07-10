package com.dpj.dao;

import com.dpj.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 查询信息需要的用户姓名
     * @return 返回一个对应的用户，返回null则表示用户不存在
     */
    public User queryUserByUserName(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 返回一个对应的用户，如果返回null则表示用户不存在
     */
    public User queryUserByUserNameAndPassword(String username,String password);

    /**
     * 添加用户
     * @param user 需要被添加的用户
     * @return 返回-1则表示添加失败
     */
    public int saveUser(User user);
}
