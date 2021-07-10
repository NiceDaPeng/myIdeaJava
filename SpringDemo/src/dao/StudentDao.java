package dao;

import domain.Student;

public class StudentDao {
    public Student selectOne(){
        System.out.println("DAO层执行了");
        System.out.println("DAO层执行完毕");
        return null;
    }
}
