package testbuffered;

import java.io.*;

public class Login {

    public static void main(String[] args) {

        Login login = new Login();
        String msg = login.loginTest("秦兰兰", "123");
        System.out.println(msg);
    }

    public String loginTest(String name ,String password){

        File file = new File("E:\\testIO\\Person.txt");
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String user = br.readLine();
            System.out.println(user);
            while (user != null){
                String[] split = user.split("-");
                System.out.println(split[0]+","+split[1]);
                if (split[0].equals(name)){
                    if (split[1].equals(password)){
                        return "登录成功";
                    }
                }
                user = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "账号或密码错误";

    }
}
