package view;

import service.impl.ServiceImpl;

import java.util.Scanner;

public class ShowMessage {
    private  ServiceImpl service = new ServiceImpl();
     Scanner input = new Scanner(System.in);

    //设计一个方法用来展示信息
    public  void showMessage() {
        boolean flag = true;
        while (true) {
            System.out.println("\t\t\t\t\t欢迎光临，请登录");
            login();
        }
    }

    //设计一个方法用来登录
    private  void login() {
        System.out.println("账户：");
        String uno = input.nextLine();
        System.out.println("密码：");
        String upassword = input.nextLine();
        boolean login = service.login(uno, upassword);
        if (login == true) {
            this.showUserMessage(uno);
        }
        System.out.println("登录失败");
    }


    private void showUserMessage(String uno) {
        String userName = service.getUserName(uno);
        System.out.println("\t\t\t\t\t欢迎" + userName + "请选择您要执行的操作");
        System.out.println("1,转账；2，存钱；3，取钱；4，退出");
        int check = input.nextInt();
        switch (check) {
            case 1:
                zhuanzhang(uno);
                break;
            case 2:
                inMoney(uno);
                break;
            case 3:
                outMoney(uno);
                break;
            case 4:
                System.out.println("确认退出吗？");
                char c = input.nextLine().charAt(0);
                if (c=='Y' || c=='y'){

                }
                break;
            default:
                System.out.println("请重新输入");
                break;
        }
    }

    //设计一个方法用来执行转账操作
    public void zhuanzhang(String cno){
        System.out.println("请输入您要转入的账户：");
        String othercno = input.nextLine();
        System.out.println("请输入您要转入的金额");
        Float money = input.nextFloat();
        int zhuanzhang = service.zhuanzhang(cno, othercno, money);
        if (zhuanzhang > 0){
            System.out.println("操作成功");
        } else {
            System.out.println("操作失败");
        }
    }

    public void inMoney(String uno){
        System.out.println("请输入您要存入的金额");
        float money = input.nextFloat();
        int in = service.inMoney(uno, money);
        if (in > 0){
            System.out.println("操作成功");
        } else {
            System.out.println("操作失败");
        }
    }

    public void outMoney(String uno){
        System.out.println("请输入您要取得金额：");
        float money = input.nextFloat();
        int outMoney = service.outMoney(uno, money);
        if (outMoney >0){
            System.out.println("操作成功");

        }else {
            System.out.println("操作失败");
        }
    }
}
