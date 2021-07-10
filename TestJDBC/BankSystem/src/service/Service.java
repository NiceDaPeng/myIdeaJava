package service;

import domain.Customers;

public interface Service {

    //设计一个方法用来转账
    int zhuanzhang(String cno,String othercno,Float money );
    //设计一个方法用来存钱
    int inMoney(String cno,Float money);
    //设计一个方法用来取钱
    int outMoney(String cno,Float money);

    //

    /**
     * 设计一个方法用来登录
     * @param num  账户
     * @param password 密码
     * @return  登录成功返回true，否则返回false
     */
    boolean login(String num,String password);

    //设计一个方法用来获取用户名
    String getUserName(String cno);
}
