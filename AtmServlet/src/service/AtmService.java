package service;

import com.alibaba.druid.util.JdbcUtils;
import dao.BasicDao;
import dao.LoginDao;
import domain.Atm;
import util.JDBCUtil;
import util.MySpring;

import java.sql.Connection;
import java.sql.SQLException;

public class AtmService {

    private BasicDao dao = MySpring.getBean("dao.BasicDao");

    public boolean login(String username, String password) {
        boolean a = true;
        String sql = "select * from atm where aname=?";
        Atm atm = dao.queryOne(sql, Atm.class, username);
        if (atm != null) {
            if (atm.getApassword().equals(password)) {
                return a;
            }
        }
        return !a;
    }


    //设计一个方法用来查询余额
    public float selectBalance(String aname) {
        String sql = "select abalance from atm where aname=?";
        float ablance = (float) dao.queryScalar(sql, aname);
        return ablance;
    }

    //设计一个方法用来存款
    public boolean saveMoney(String aname, Float money) {
        String sql = "update atm set abalance=abalance+? where aname=?";
        int update = dao.update(sql, money, aname);
        if (update > 0) {
            return true;
        }
        return false;
    }

    public boolean outMoney(String aname, Float money) {
        float abalance = this.selectBalance(aname);
        if (money > abalance) {
            return false;
        } else {
            String sql2 = "update atm set abalance=abalance-? where aname=?";
            dao.update(sql2, money, aname);
        }
        return true;
    }


    public boolean transferMoney(String aname, Float money, String otherName) {
        Connection conn = JDBCUtil.getConn();
        float abalance = this.selectBalance(aname);
        if (money > abalance) {
            return false;
        } else {
            try {
                conn.setAutoCommit(false);
                String sql1 = "update atm set abalance = abalance-? where aname=?";
                String sql2 = "update atm set abalance = abalance+? where aname=?";
                dao.update(sql1, money, aname);
                dao.update(sql2, money, otherName);
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public Atm getAtm(String aname){
        Connection conn = JDBCUtil.getConn();
        String sql = "select `aname`,`apassword`,`abalance` from atm where aname = ?";
        return dao.queryOne(sql,Atm.class,aname);
    }
}
