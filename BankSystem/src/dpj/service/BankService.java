package dpj.service;

import dpj.bean.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class BankService {

    private ArrayList<Customer> customers = new ArrayList<>();

    {
        addCustomer();
    }

    //将文本中的数据取出来添加到集合中
    public void addCustomer(){
        FileReader fr = null;
        BufferedReader br = null;
        File file = new File("E:\\users.txt");

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String userMsg = br.readLine();
            while (userMsg != null){
                String[] split = userMsg.split("-");
                this.customers.add(new Customer(split[0],split[1],Double.parseDouble(split[2]),split[3]));
//                System.out.println(split[0]+""+split[1]+""+Double.parseDouble(split[2])+""+split[3]);
                userMsg = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (br != null){
                    fr.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                if (fr != null){
                    fr.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    //设计一个方法用来进行登录判断
    public String login(String id,String password){
        for (Customer customer : customers){
            if (customer.getId().equals(id)){
                if (customer.getPassword().equals(password)){
                    return customer.getId();
                }
            }
        }
        return "登录失败";
    }

    //设计一个方法用来查询余额
    public double getBanlance(String id){
        double banlance = 0;
        for (Customer customer : customers) {
            if (customer.getId().equals(id)){
                banlance = customer.getMoney();
                break;
            }
        }
        return banlance;
    }

    //设计一个方法用来存钱
    public double addMoney(String id,double money){
        double newMoney = 0;
        for (int i =0; i < customers.size();i++){
            if (customers.get(i).getId().equals(id)){
                customers.get(i).setMoney(customers.get(i).getMoney()+money);
                newMoney = customers.get(i).getMoney();
            }
        }
        return newMoney;
    }

    //设计一个方法用来取钱
    public void drawMoney(String id,double money){
        double newMoney = 0;
        for (Customer customer :
                customers) {
            if (customer.getId().equals(id)){
                if (customer.getMoney() - money < 0){
                    System.out.println("您好余额不足");
                    break;
                }
                customer.setMoney(customer.getMoney() - money);
                newMoney = customer.getMoney();
                System.out.println("取出后的余额为："+newMoney);
                break;
            }
        }
    }

    //设计一个方法用来转账
    public double transfersAcount(String id,String antherId,double money){
        boolean result = rangeId(antherId);
        if (result == false){
            return 1;
        }
        double newMoney = 0;
        for (Customer customer :
                customers) {
            if (customer.getId().equals(id)){
                if (money - customer.getMoney() > 0){
                    return 0;
                }
                customer.setMoney(customer.getMoney() - money);
                newMoney = customer.getMoney();
                break;
            }
        }
    for (Customer customer: customers){
        if (customer.getId().equals(antherId)){
            customer.setMoney(customer.getMoney() + money);

            break;
        }
    }
        return newMoney;
    }

    //设计一个方法用来开户
    public String openAcount(String name,String password){
        Date date = new Date();
        String id = String.valueOf(date.getTime());
        customers.add(new Customer(id,name,0,password));
        System.out.println("添加成功！");
        System.out.println("您的账户为:"+id+"请牢记此账户");
        return id;
    }

    //设计一个方法用来销户
    public void closeAcount(String id){
        for (int i =0; i < customers.size();i++){
            if (customers.get(i).getId().equals(id)){
                customers.remove(i);
                System.out.println("销户成功");
                break;
            }
        }
    }

    //检查id
    private boolean rangeId(String id){
        for (Customer customer:customers){
            if (customer.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    //设计一个方法用来将数据写入
    public void writeDate(){
        File file = new File("E:\\users.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < customers.size();i++){
                String cus = customers.get(i).getId()+"-"+customers.get(i).getName()+"-"+customers.get(i).getMoney()+"-"+customers.get(i).getPassword();
                bw.write(cus);
                bw.flush();
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
