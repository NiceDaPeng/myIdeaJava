package com.dpj.view;

import com.dpj.bean.Customer;
import com.dpj.service.CustomerService;

import java.util.Scanner;

public class CustomerView {


    CustomerService cs = new CustomerService();
    Scanner input = new Scanner(System.in);
    public void showMenu() {

        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println("\t\t\t\t1 添加客户");
            System.out.println("\t\t\t\t2 修改客户");
            System.out.println("\t\t\t\t3 删除客户");
            System.out.println("\t\t\t\t4 客户列表");
            System.out.println("\t\t\t\t5 退   出");
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println("\t\t\t请选择1-5:");
            int value = input.nextInt();
            switch(value){
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    replaceCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    listAllCustomers();
                    break;
                case 5:
                    System.out.println("确认退出吗？");
                    char charAt = input.next().charAt(0);
                    if (charAt == 'Y' || charAt == 'y'){
                        flag = false;
                    }
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    private void addNewCustomer(){
        System.out.println("-----------------添加信息-----------------");
        System.out.println("姓名：");
        String name = input.nextLine();
        System.out.println("性别：");
        String sex = input.nextLine();
        System.out.println("年龄：");
        String ageStr = input.nextLine();
        int age = Integer.parseInt(ageStr);
        System.out.println("phone：");
        String phone = input.nextLine();
        System.out.println("email：");
        String email = input.nextLine();
        boolean addorNo = cs.addCus(new Customer(name,sex,age,phone,email));
        System.out.println("-----------------添加成功-----------------");
    }
    private boolean replaceCustomer(){

        System.out.println("-----------------修改信息-----------------");
        System.out.println("请输入您要修改的人员的编号");
        String indexStr = input.nextLine();
        int index = Integer.parseInt(indexStr);
        System.out.println("姓名：");
        String name = input.nextLine();
        System.out.println("性别：");
        String sex = input.nextLine();
        System.out.println("年龄：");
        String ageStr = input.nextLine();
        int age = Integer.parseInt(ageStr);
        System.out.println("phone：");
        String phone = input.nextLine();
        System.out.println("email：");
        String email = input.nextLine();
        System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t\t电话\t\t\t邮箱");
        cs.replacecue(index-1,new Customer(name,sex,age,phone,email));

        System.out.println("-----------------修改成功-----------------");
        return true;
    }
    private boolean deleteCustomer(){
        System.out.println("-----------------删除信息-----------------");
        System.out.println("请输入你要删除的员工的编号");
        int index  = input.nextInt();
        System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t\t电话\t\t\t邮箱");
        cs.deleteCue(index-1);
        System.out.println("-----------------删除成功-----------------");
        return true;
    }
    private void listAllCustomers(){
        System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t\t电话\t\t\t邮箱");

        cs.getAllCustomers();
    }


}
