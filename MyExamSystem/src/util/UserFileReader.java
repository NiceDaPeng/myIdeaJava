package util;

import bean.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserFileReader {
    //设计一个类用来将user中的属性读取到缓存中。
    private static HashMap<String,User> usersMap = new HashMap<>();

    static {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/dbfile/User.txt"));
            String value;
            while ((value = br.readLine()) != null){
                String[] split = value.split("-");
                usersMap.put(split[0],new User(split[0],split[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String,User> getUsersMap(){
        return usersMap;
    }
}
