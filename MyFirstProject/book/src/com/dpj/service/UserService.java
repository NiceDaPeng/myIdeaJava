package com.dpj.service;

import com.dpj.pojo.User;

public interface UserService {
    /**
     * 用来对验证码进行正确验证
     * @param code
     * @return
     */
    public boolean verfify(String code);

    /**
     * 判断登录是否成功
     * @param username 需要的用户名
     * @param passwrod  用以判断的密码
     * @return 返回true则说明登录成功 false则说明登录失败
     */
    public boolean login(String username,String passwrod);

    /**
     * 注册信息
     * @param user 用以注册的用户
     * @return  返回true则说明存在用户，false则说明不存在
     */
    public boolean regist(User user);
}
