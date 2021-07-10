package service;

import domain.Customer;

import java.util.Map;

public interface DataService {

    //取钱
    boolean outMoney(String userid,Float money);

    //存钱
    void inMoney(String userid,Float money);

    //转账
    boolean zhuanzhang(String userid,String otherid,Float money);


    //开户
    boolean openAccount(String username,String password,float balance);

    //销户
    boolean closedAccount();

    Customer selectOne(String userid);


}
