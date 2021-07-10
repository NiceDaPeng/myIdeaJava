package service;

import dao.StudentDao;
import domain.Student;

public class StudentService {
    private StudentDao dao;

    public void setDao(StudentDao dao) {
        System.out.println("service的set方法");
        this.dao = dao;
    }

    public StudentService() {
        System.out.println("service的五参数构造方法");
    }

    public StudentService(StudentDao dao) {
        System.out.println("service的构造方法dao属性被赋值");
        this.dao = dao;
    }

    public Student selectOne(){
        System.out.println("service层执行了");
        dao.selectOne();
        System.out.println("service层执行完毕");
        return null;
    }
}
