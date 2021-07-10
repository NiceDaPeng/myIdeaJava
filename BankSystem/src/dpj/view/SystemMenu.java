package dpj.view;

import dpj.service.BankService;

import java.util.Scanner;

public class SystemMenu {

    Scanner input = new Scanner(System.in);
    private BankService banks = new BankService();
    private static String userId ;

    //设计一个方法用来展示界面
    public void showMenu() {
        login();
        boolean flag = true;
        while (flag) {
            System.out.println("\t\t"+userId+"欢迎光临到处都是钱银行");
            System.out.println("\t\t\t\t1查询余额");
            System.out.println("\t\t\t\t2存    款");
            System.out.println("\t\t\t\t3取    款");
            System.out.println("\t\t\t\t4转    账");
            System.out.println("\t\t\t\t5开    户");
            System.out.println("\t\t\t\t6销    户");
            System.out.println("\t\t\t\t0退    出");
            System.out.println("\t\t\t\t(请选择0-6:)");
            String select = input.nextLine();
            switch (select) {
                case "1":
                    this.getMoney();
                    break;
                case "2":
                    this.addMoney();
                    break;
                case "3":
                    drawMoney();
                    break;
                case "4":
                    transferAcount();
                    break;
                case "5":
                    openAcount();
                    break;
                case "6":
                    closeAcount();
                    break;
                case "0":
                    flag = logOut();
                    break;
                default:
                    System.out.println("您的输入有误请重新输入");
                    break;
            }
        }
    }

    //
    //设计一个方法用来进行登录判断
    public void login(){

        System.out.println("\t\t*****登录*****");
        System.out.println("请输入您的账户：");
        String userId = input.nextLine();
        System.out.println("请输入密码");
        String userPassword = input.nextLine();
        String result = banks.login(userId, userPassword);
        if (result .equals("登录失败")){
            showMenu();
        }
        this.userId = result;

    }

    //设计一个方法用来查询余额
    public void getMoney(){
        System.out.println("余额为："+banks.getBanlance(userId));
    }

    //设计一个方法用来存钱
    public void addMoney(){
        System.out.println("请输入您要存入的金额");
        String inMoney = input.nextLine();
        System.out.println("存入后的金额为："+banks.addMoney(userId,Double.parseDouble(inMoney)));
    }

    //设计一个方法用来取钱
    public void drawMoney(){
        System.out.println("请输入您要取的金额");
        double outMoney = Double.parseDouble(input.nextLine());
        banks.drawMoney(userId, outMoney);
    }

    //设计一个方法用来转账
    public void transferAcount(){
        System.out.println("请输入您要转出的金额");
        Double money = Double.parseDouble(input.nextLine());
        System.out.println("请输入对方的id");
        String antherId = input.nextLine();
        double result = banks.transfersAcount(userId,antherId, money);
        if (result == 0){
            System.out.println("您的转出金额超出总金额");
        }else if(result == 1){
            System.out.println("账户ID不存在");
        }else {
            System.out.println("转出成功,转出后的金额为；"+result);
        }

    }

    //设计一个方法用来开户
    public void openAcount(){
        System.out.println("请输入姓名：");
        String name = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        System.out.println("请再次输入密码");
        String againPassword = input.nextLine();
        if (againPassword.equals(password)){
            userId = banks.openAcount(name,password);
        } else {
            this.openAcount();
        }
    }

    //设计一个方法用来销户
    public void closeAcount(){
        banks.closeAcount(userId);
        userId = null;
        this.login();
    }

    //设计一个方法用来退出系统
    public boolean logOut(){
        System.out.println("确定退出吗？Y/N");
        char charAt = input.next().charAt(0);
        if (charAt == 'Y' || charAt == 'y'){
            System.out.println(userId+"欢迎您的使用，再见！");
            banks.writeDate();
            return false;
        }
        return true;
    }

}
