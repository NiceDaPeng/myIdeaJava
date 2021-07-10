package service;

import dao.AdminDao;
import domain.Admin;

public class AdminService {

    public boolean login(String username,String password){
        AdminDao dao = new AdminDao();
        String sql = "select aname,apassword from admin where aname=?";
        Admin admin = dao.selectOne(sql, Admin.class, username);
        if (admin != null){
            return true;
        }
        return false;
    }

}
