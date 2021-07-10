package com.dpj.dao.impl;

import com.dpj.dao.UserDao;
import com.dpj.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUserName(String userName) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username=?";
        return queryForOne(User.class,sql,userName);
    }

    @Override
    public User queryUserByUserNameAndPassword(String userName, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username=? and password = ?";
        return queryForOne(User.class,sql,userName,password);

    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`id`,`username`,`password`,`email`) values(?,?,?,?)";
        return update(sql,user.getId(),user.getUsername(),user.getPassword(),user.getEmail());
    }
}
