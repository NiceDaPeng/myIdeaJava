package dao.impl;

import dao.UserDao;
import domain.User;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUserName(String userName) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username=?";
        User user = this.queryForOne(sql, User.class, userName);
        return user;
    }

    @Override
    public int saveUser(User user) {

        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        int update = this.update(sql, user.getUserName(), user.getPassword(), user.getEmail());
        return update;
    }

    @Override
    public User queryUserByUserNameAndPassword(String userName, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where userName=? and password=?";
        User user = queryForOne(sql, User.class, userName, password);
        return user;
    }
}
