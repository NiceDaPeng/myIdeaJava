package service;

import domain.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return  返回true则表示存在， false则不存在
     */
    public boolean existsUser(String username);
}
