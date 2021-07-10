package test;

import domain.User;
import org.junit.Test;
import service.UserService;
import service.impl.UserServiceImpl;

public class UserServiceTest {

    UserService service = new UserServiceImpl();
    @Test
    public void registUser() {
        service.registUser(new User(null,"three","111111","three@dpj.com"));
    }

    @Test
    public void login() {

        System.out.println(service.login(new User(null,"second","111111","null")));
    }

    @Test
    public void existsUser() {

        boolean admin = service.existsUser("admin");
        if (admin == true){
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名可用");
        }
    }
}
