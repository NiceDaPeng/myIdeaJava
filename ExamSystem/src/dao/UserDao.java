package dao;

import domain.User;
import util.UserFileReader;

public class UserDao {
    //缓存---虚拟机(内存中)---存储文件中的所有信息

    //负责查询一个人的信息
    //  参数账号  返回值domain
    public User selectOne(String account){
        return UserFileReader.getUser(account);
    }
}
