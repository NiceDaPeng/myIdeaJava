package dao;

import domain.User;

public interface UserDao {

    /**
     * 根据用户名查询一条用户信息
     * @param userName 用户名
     * @return 如果返回null，说明没有这个用户。
     */
    public User queryUserByUserName(String userName);

    /**
     * 保存用户信息
     * @param user
     * @return  返回-1则表示操作失败，其它则是受影响的行数
     */
    public int saveUser(User user);

    /**
     * 根据用户名和密码查询用户信息
     * @param userName
     * @param password
     * @return  返回null则没有此用户
     */
    public User queryUserByUserNameAndPassword(String userName, String password);
}
