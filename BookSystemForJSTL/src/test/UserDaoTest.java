package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao dao = new UserDaoImpl();
    @Test
    public void queryUserByUserName() {

        User admin = dao.queryUserByUserName("admin");
//        System.out.println(admin.getUserName());
        if (admin == null){
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
//            System.out.println(admin.getUserName());
        }
    }

    @Test
    public void saveUser() {
        User user = new User(null,"second","111111","123456@dpj.com");
        int i = dao.saveUser(user);
        System.out.println(i);

    }

    @Test
    public void queryUserByUserNameAndPassword() {
        User user = dao.queryUserByUserNameAndPassword("admin", "admin");
        if (user == null){
            System.out.println("登录失败");
        } else {
            System.out.println("查询成功");
        }
    }
}
