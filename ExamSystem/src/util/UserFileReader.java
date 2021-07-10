package util;

import domain.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class UserFileReader {
    //创建一个集合--->充当一个缓存
    private static HashMap<String,User> userBox = new HashMap<>();
    public static User getUser(String account){
        return userBox.get(account);
    }

    //在当前类加载的时候先执行
    static{
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src//dbfile//User.txt"));
            String user = reader.readLine();//每一次读取文件中一行记录
            while(user!=null){
                String[] values = user.split("-");//一行记录的两个信息 账号 密码
                userBox.put(values[0],new User(values[0],values[1]));
                user = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(reader!=null) {
                    reader.close();
                }
            }  catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
