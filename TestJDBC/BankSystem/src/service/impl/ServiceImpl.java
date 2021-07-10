package service.impl;

import dao.DButils;
import domain.Customers;
import service.Service;

import java.sql.SQLException;
import java.util.Map;

public class ServiceImpl implements Service {

    @Override
    public int zhuanzhang(String cno, String othercno,Float money) {
        String sql = "update users set cbalance = cbalance-"+money +"where cno="+cno;
        String sql1 = "update users set cbalance = cbalance+"+money+"where cno="+othercno;
        int num = DButils.updateData(sql);
        return num;
    }

    @Override
    public int inMoney(String cno,Float money) {
        String sql = "update users set cbalance = cbalance+"+money+"where cno="+cno;
        int num = DButils.updateData(sql);
        return num;
    }

    @Override
    public int outMoney(String cno,Float money) {
        return 0;
    }

    @Override
    public boolean login(String cno, String password) {
        try {
            Map<String, String> message = DButils.getMessage(cno);
            if (message.size() != 0){
                String cpassword = message.get(cno);
                if (cpassword.equals(password)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getUserName(String cno) {
        String uname=null;
        try {
            uname = DButils.getUserName(cno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uname;
    }


}
