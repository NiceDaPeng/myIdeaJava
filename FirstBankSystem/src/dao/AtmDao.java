package dao;

import domain.Atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("all")
public class AtmDao {

    //Dao--数据读写(JDBC)--持久层

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/banksystem?useSSL=true";
    private String user = "root";
    private String password = "admin";

    //设计一个方法 负责查询一行记录
    public Atm selectOne(String aname){
        Atm atm = null;
        String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM atm WHERE ANAME = ?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,aname);
            ResultSet rs = pstat.executeQuery();
            if(rs.next()){
                atm = new Atm();
                atm.setAname(rs.getString("aname"));
                atm.setApassword(rs.getString("apassword"));
                atm.setAbalance(rs.getFloat("abalance"));
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atm;
    }

    //设计一个方法 新增一行记录
    public int insert(Atm atm){
        int count = 0;//数据库更改的行数==1
        String sql = "INSERT INTO ATM VALUES(?,?,?)";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,atm.getAname());
            pstat.setFloat(2,atm.getAbalance());
            pstat.setString(3,atm.getApassword());
            count = pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    //设计一个方法 做数据库更新
    public int update(Atm atm){
        int count = 0;//记录更改的行数
        String sql = "UPDATE ATM SET APASSWORD = ? , ABALANCE = ? WHERE ANAME = ?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,atm.getApassword());
            pstat.setFloat(2,atm.getAbalance());
            pstat.setString(3,atm.getAname());
            count = pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    //设计一个方法 删除记录
    public int delete(String aname){
        int count = 0;//数据库更改的行数==1
        String sql = "DELETE FROM ATM WHERE ANAME = ?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,aname);
            count = pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

}
