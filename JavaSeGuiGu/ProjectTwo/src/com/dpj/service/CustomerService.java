package com.dpj.service;

import com.dpj.bean.Customer;
import projecttwodemo.CustomerException;

public class CustomerService {

    private int size  = 10;
    private Customer[] customers = new Customer[size];
    int total = 0;
    {
        customers[0] = new Customer("段小誉", "男", 20, "222", "3000");
        customers[1] = new Customer("令狐冲", "男", 23, "223", "3000");
        customers[2] = new Customer("段正淳", "男", 22, "221", "3000");
        customers[3] = new Customer("乔啊峰", "男", 22, "225", "3000");
        customers[4] = new Customer("九姑娘", "女", 21, "222", "3000");
        customers[5] = new Customer("鸠摩智", "男", 22, "226", "3000");
    }
    public int getSize() {
        return size;
    }

    private void ensuerCapacity(int minCapacity){
        if (minCapacity - customers.length > 0){
            //扩容
            this.grow(minCapacity);
        }
    }

    //扩容方法
    private void grow(int minCapacity){
        int oldCapacity = customers.length;
        int newCapacity = oldCapacity + oldCapacity >> 1;
        if (minCapacity - newCapacity > 0){
            newCapacity = minCapacity;
        }
        //复制原数组内的元素到新的数组
        customers = this.copyOf(this.customers, newCapacity);
    }

    //复制原数组内的元素到新的数组
    private Customer[] copyOf(Customer[] customers,int newCapacity){
        Customer[] newArray = new Customer[newCapacity];
        for (int i = 0; i < this.customers.length;i++){
            newArray[i] = this.customers[i];
        }
        return newArray;
    }

    public boolean addCus(Customer customer){
        ensuerCapacity(total+1);
        this.customers[total++] = customer;
        return false;
    }

    public boolean deleteCue(int index){

        this.rangeIndex(index);
        for (int i = 0; i < customers.length - index -1 ;i++){
            rangeIndex(index);
            this.customers[index] = this.customers[index + i + 1];
        }
        customers[customers.length -1] = null;
        this.getAllCustomers();
        return true;
    }

    public void replacecue(int index,Customer cust){
        this.rangeIndex(index);

        for (int i = 0; i < customers.length; i++){
            if (index ==i){
                System.out.println("修改前的信息为："+customers[i]);
                break;
            }
        }
        customers[index] = new Customer(cust.getName(),cust.getGender(),
                cust.getAge(),cust.getPhone(),cust.getEmail());
        System.out.println("修改后的信息为："+customers[index]);
    }

    public void getAllCustomers(){

        int flag = 1;
        for (Customer customer:customers){
            if (customer != null){
                System.out.println(flag++ +"\t"+ customer);
            }
        }
    }

    public void rangeIndex(int index){
        if (index > customers.length || index < 0){
            throw new CustomerException("index ："+index+"length:"+ customers.length);
        }
    }
}
