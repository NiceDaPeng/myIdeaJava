package com.dpj.arraylist.test;

import com.dpj.arraylist.dao.BasicDao;
import com.dpj.arraylist.domain.Admin;
import com.dpj.arraylist.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

//        String sql = "update emp set comm = ? where empno=?";
//        BasicDao dao = new BasicDao();
//        int update = dao.update(sql, 1000, 7369);
//        if (update>0){
//            System.out.println("操作成功");
//        }

//        String sql1 = "select aname,apassword from admin where aname=? ";
//        BasicDao dao = new BasicDao();
//        Admin admin = dao.selectOne(sql1, Admin.class, 1);
//        System.out.println(admin);

//        String sql2 = "select apassword from admin where aname= ?";
//        BasicDao dao  = new BasicDao();
//        Object o = dao.queryScalar(sql2, 1);
//        Class<?> aClass = o.getClass();
//        System.out.println(aClass);
//        System.out.println(o);

        String sql = "select * from admin";
        BasicDao dao = new BasicDao();
        Connection conn = JDBCUtil.getConn();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Admin> admins = dao.selectList(sql, Admin.class);
        for (Admin obj :
                admins) {
            System.out.println(obj);
        }
        
    }
}
