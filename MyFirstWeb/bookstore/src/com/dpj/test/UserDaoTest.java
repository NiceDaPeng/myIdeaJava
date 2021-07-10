package com.dpj.test;

import com.dpj.dao.UserDao;
import com.dpj.dao.impl.UserDaoImpl;
import com.dpj.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUserName() {

        if ((userDao.queryUserByUserName("admin")) == null){
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已经存在");
        }
    }

    @Test
    public void queryUserByUserNameAndPassword() {
        if (userDao.queryUserByUserNameAndPassword("admin", "admin") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {

        System.out.println(userDao.saveUser(new User(null,"goods","123456","good@dpj.com")));
    }
}