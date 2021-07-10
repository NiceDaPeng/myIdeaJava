package Service;

public class UserService {

    //登录方法
    public String login(String username,String password){

        if ("dpj".equals(username) && "888".equals(password)){
            return "登录成功";
        }
        return "账号或密码错误";
    }
}
