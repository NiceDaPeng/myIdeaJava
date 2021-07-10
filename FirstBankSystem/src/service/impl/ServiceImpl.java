package service.impl;

import dao.DataBaseConn;
import domain.Customer;
import service.DataService;

import java.sql.SQLException;

public class ServiceImpl implements DataService {
//    private static Map<String, String> map = dataBaseConn.getMap();
    private  DataBaseConn dataBaseConn = new DataBaseConn();
    @Override
    public boolean outMoney(String userid, Float money) {
        Customer customer = this.selectOne(userid);
        if (customer.getBalance() >= money) {
            customer.setBalance(customer.getBalance() - money);
            try {
                dataBaseConn.updateData(customer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 存钱方法
     *
     * @param userid 用户id
     * @param money  存入的钱
     */
    @Override
    public void inMoney(String userid, Float money) {
        Customer customer = this.selectOne(userid);
        customer.setBalance(customer.getBalance() + money);
        try {
            dataBaseConn.updateData(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 转账方法
     * @param userid 转出的账户
     * @param otherid 转入的账户
     * @param money 转出金额
     * @return true表示转出成功， false则失败。
     */
    @Override
    public boolean zhuanzhang(String userid, String otherid, Float money) {
        Customer customer = this.selectOne(userid);
        Customer otherCustomer = this.selectOne(otherid);
        if (money <= customer.getBalance()){
            customer.setBalance(customer.getBalance()-money);
            otherCustomer.setBalance(otherCustomer.getBalance()+money);
            try {
                dataBaseConn.updateData(customer);
                dataBaseConn.updateData(otherCustomer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean openAccount(String username,String password,float balance) {
        long temptime = System.currentTimeMillis();
        try {
            dataBaseConn.insertData(new Customer(String.valueOf(temptime),username,password,balance));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean closedAccount() {
        return false;
    }

    @Override
    public Customer selectOne(String userid) {
        Customer customer = null;
        try {
            customer = dataBaseConn.queryOneData(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
