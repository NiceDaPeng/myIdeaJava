package service;

import dao.StudentDao;
import domain.Student;

import java.util.List;

public class StudentService {

    private StudentDao dao = new StudentDao();
    //设计一个发方法用来查询学生的信息和所学老师的信息
    public Student selectOne(Integer sid){
        return dao.selectOne(sid);
    }

    //设计一个方法用来查询所有的学生的信息
    public List<Student> selectAll(){
        return dao.selectAll();
    }
}
