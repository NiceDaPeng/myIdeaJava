package view;

import dao.DataBaseConn;
import domain.Customer;
import service.impl.ServiceImpl;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class ShowMessage {
    private Scanner input = new Scanner(System.in);
    private ServiceImpl service = new ServiceImpl();

    public void login() {
        System.out.println("尊敬的贵宾您好请登录");
        boolean flag = true;
        System.out.println("账户：");
        String userid = input.nextLine();
        System.out.println("密码：");
        String password = input.nextLine();
        if (testLogin(userid,password) == true){
            System.out.println(service.selectOne(userid).getUserName() + "您好，欢迎您的光临");
            showTwo(userid);
        } else {
            System.out.println("用户名或密码错误，请重新输入");
            login();
        }
    }

    public boolean testLogin(String userid,String password) {
        Customer customer = service.selectOne(userid);
        if (customer != null){
            if (customer.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }



    //设计一个方法用来展示第二界面
    public void showTwo(String userid) {
        while (true) {
            System.out.println("请选择您的操作1,查询余额；2，存钱；3，取钱；4，转账；5，开户；6，销户;7，退出");
            String option = input.nextLine();
            if (option.equals("0")) {
                break;
            }
            switch (option) {
                case "1":
                    selectMoney(userid);
                    break;
                case "2":
                    inMoney(userid);
                    break;
                case "3":
                    outMoney(userid);
                    break;
                case "4":
                    zhuanzhang(userid);
                    break;
                case "5":
                    openAccount();
                    break;
                case "6":
                    closeAccount();
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    private void closeAccount() {

    }

    private void openAccount() {
        System.out.println("请输入您的姓名");
        String username = input.nextLine();
        System.out.println("请输入密码");
        String password = input.nextLine();
        System.out.println("请输入您要存入的金额：");
        float balance = Float.parseFloat(input.nextLine());
        service.openAccount(username,password,balance);
        System.out.println("账户创建成功");
    }

    private void zhuanzhang(String userid) {
        System.out.println("请输入您要转入的账号：");
        String otherUserId = input.nextLine();
        System.out.println("请输入您要转入的金额：");
        float newMoney = input.nextFloat();
        input.nextLine();
        boolean temp = service.zhuanzhang(userid, otherUserId, newMoney);
        if (temp == true){
            System.out.println("转出成功,存入后的余额为："+service.selectOne(userid).getBalance());
        } else {
            System.out.println("余额不足");
        }
    }

    private void outMoney(String userid) {
        System.out.println("请输入您要取的金额：");
        float newMoney = input.nextFloat();
        input.nextLine();
        boolean temp = service.outMoney(userid, newMoney);
        if (temp == true) {
            System.out.println("取出成功,存入后的余额为：" + service.selectOne(userid).getBalance());
            showTwo(userid);
        } else {
            System.out.println("余额不足您的余额为："+service.selectOne(userid).getBalance());
        }
    }

    private void selectMoney(String userid) {
        Customer customer = service.selectOne(userid);
        System.out.println( customer.getUserName() + "您的余额为：" + customer.getBalance());
    }

    private void inMoney(String userid) {
        System.out.println("请输入您要存入的金额：");
        float newMoney = input.nextFloat();
        input.nextLine();
        service.inMoney(userid, newMoney);
        System.out.println("存入成功");
        System.out.println("存入后的余额为："+service.selectOne(userid).getBalance());
    }

}
