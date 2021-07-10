package controller;

import dao.StudentDao;
import domain.Student;
import service.StudentService;

public class StudentController {

    private StudentService service;

    public void setService(StudentService service) {
        System.out.println("controller的set方法");
        this.service = service;
    }

    public StudentController() {
        System.out.println("controller的五参数构造方法");
    }

    public StudentController(StudentService service) {
        System.out.println("controller的构造方法service属性被赋值了");
        this.service = service;
    }

    public Student selectOne(){
        System.out.println("controller层执行了");
        service.selectOne();
        System.out.println("controller层执行完毕");
        return null;
    }
}
