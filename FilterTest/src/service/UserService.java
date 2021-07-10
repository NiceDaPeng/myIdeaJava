package service;

public class UserService {

    public String login(String username){
        if ("zhangsan".equals(username)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }

}
