package view;

import domain.Admin;
import service.AdminService;

import java.util.Scanner;

public class ShowMessage {
    private Scanner input = new Scanner(System.in);
    private AdminService service = new AdminService();
    public void login(){
        System.out.println("请输入用户名：");
        String username = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        boolean login = service.login(username, password);
        if (login == true){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}
