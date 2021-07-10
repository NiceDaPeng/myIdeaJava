package projecttwodemo;

import java.util.Scanner;

public class CustomerView {

    public CustomerList customers = new CustomerList(2);
    CustomerList list = new CustomerList();
    Scanner input = new Scanner(System.in);

    public void enterMainMenu(){
        boolean flag = true;
        while(flag){
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println("\t\t\t1 添加客户");
            System.out.println("\t\t\t2 修改客户");
            System.out.println("\t\t\t3 删除客户");
            System.out.println("\t\t\t4 客户列表");
            System.out.println("\t\t\t5 退   出");
            System.out.print("\t\t\t请选择:");
            String select = input.nextLine();
            int value = Integer.parseInt(select);
            switch(value){
                case 1:
                    this.addNewCustomer();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    this.listAllCustomers();
                    break;
                case 5:
                    System.out.println("确认退出吗？");
                    char charAt = input.next().charAt(0);
                    if (charAt == 'Y' || charAt == 'y'){
                        flag = false;
                    }
                    break;
            }
        }



    }

    private void addNewCustomer(){
        System.out.println("---------------------添加客户---------------------\n");
        System.out.println("姓名：");
        String name = input.nextLine();

        System.out.println("性别：");
        char sex = input.next().charAt(0);
        input.nextLine();

        System.out.println("年龄：");
        String ageStr = input.nextLine();
        int age = Integer.parseInt(ageStr);

        System.out.println("电话：");
        String phone = input.nextLine();

        System.out.println("邮箱：");
        String email = input.nextLine();
        boolean matches = email.matches("[a-zA-Z\\d]{6}@[a-z]{2}.com");
        boolean addTest;
        if (matches == true){
            addTest = list.addCustomer(new Customer(name,sex,age,phone,email));
            System.out.println("---------------------添加完成---------------------\n");
        }else {
            addTest = false;
            System.out.println("---------------------添加失败---------------------\n");
        }

        System.out.println(addTest);



    }

    private void modifyCustomer(){

    }

    private void deleteCustomer(){

    }

    private void listAllCustomers(){
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
        list.getAllCustomers();
        System.out.println("---------------------------客户列表完成---------------------------");
    }

    public static void main(String[] args){
        CustomerView cv = new CustomerView();
        cv.enterMainMenu();
    }

}
