package service;

import dao.UserDao;
import domain.User;
import util.MyUtil;

public class UserService {
    private UserDao dao = MyUtil.getMapper(UserDao.class,true);
    //设计一个方法用来实现注册功能
    public String regist(User user){
        String existsUname = this.existsUname(user.getUname());
        if ("账户可用".equals(existsUname)){
            dao.insert(user);
            return "注册成功";
        }
        return "注册失败";
    }

    //设计一个方法用来判断账户是否存在
    public String existsUname(String uname){
        User temp = dao.selectOne(uname);
        if (temp != null){
            return "账户已经存在";
        }
        return "账户可用";
    }
}
