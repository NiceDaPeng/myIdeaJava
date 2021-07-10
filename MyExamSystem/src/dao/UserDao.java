package dao;

import bean.User;
import util.UserFileReader;

import java.util.HashMap;

public class UserDao {

    public static User selectOne(String account){
        return UserFileReader.getUsersMap().get(account);
    }
}
