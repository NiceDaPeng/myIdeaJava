package service;

import dao.StudentDao;
import domain.Student;

public class StudentService {

    private StudentDao dao = new StudentDao();
    //设计一个方法用来验证登录
    public String login(String saccount,String spassword){
        Student student = dao.selectOne(saccount);
//        ThreadLocal local = new ThreadLocal();
//        local.set(student);
        if (student != null && spassword.equals(student.getSpassword())){
            return "登录成功";
        } else {
            return "账号或密码错误";
        }

    }
}
