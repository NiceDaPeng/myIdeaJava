package com.dpj.dao;

import com.dpj.pojo.User;

public interface UserDao {



    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return 如果返回null，说明没有这个用户，反之则有。
     */
    public User queryUserByUserName(String userName);

    /**
     * 根据用户名和密码查询用户信息
     * @param userName
     * @param password
     * @return 如果返回null，说明没有这个用户，反之则有。
     */
    public User queryUserByUserNameAndPassword(String userName,String password);

    /**
     * 保存用户信息
     * @param user
     * @return 操作成功的行数。返回-1表示操作失败
     */
    public int saveUser(User user);
}
