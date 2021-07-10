package service;

import bean.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Service {

    private static HashSet<Double> moneySet = new HashSet<>();

    public static HashSet<Double> getMoneySet() {
        return moneySet;
    }

    public static void setMoneySet(HashSet<Double> moneySet) {
        Service.moneySet = moneySet;
    }

    public static void getMoneySet(Double money, int count) {

//        System.out.println("请输入红包总金额：");
//        String newCount = input.nextLine();
//        double moneySum = Double.parseDouble(newCount);
//        System.out.println("请输入红包个数");
//        String acount = input.nextLine();
//        int redCount = Integer.parseInt(acount);
        double random = Math.random() * money;
        moneySet.add(random);
        if (money - random > 0){
            getMoneySet(money - random, count--);
        } else {
            System.out.println("红包已经被抢完");
        }
    }

    public static void getRedMoney(String name){

        User u1 = new User("张三",3000);
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您要发的红包的金额");
        double money = input.nextDouble();

        System.out.println("请输入您要发的红包的个数");
        int count = input.nextInt();

        Service.getMoneySet(money,count);
        HashSet<Double> moneySet = Service.getMoneySet();
        for (int i = 0 ; i < moneySet.size();i++){

        }

    }
}
