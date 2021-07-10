package dao.impl;

import dao.BasicDao;
import domain.User;

public class UserDao extends BasicDao {

    //根据姓名到数据库中读取信息
    public User selectOneUser(String uname){
        String sql = "select uname,upassword from user where uname=?";
        return queryOne(sql, User.class, uname);
    }

    //注册
    public boolean regist(String uname,String password){
        User user = this.selectOneUser(uname);
        if (user == null){
            String sql = "insert into user values(?,?)";
            int update = update(sql, uname, password);
            if (update > 0){
                return true;
            }
        }
        return false;

    }


}
