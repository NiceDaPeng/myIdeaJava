package service;

import dao.StudentDao;
import domain.Student;
import util.MyUtil;

import java.util.List;

public class StudentService {
    private StudentDao dao = MyUtil.getMapper(StudentDao.class,true);
    //设计一个方法根据学生的编号，查询学生的信息以及它所上的课程
    public Student selectOne(Integer sid){
        return dao.selectOne(sid);
    }

    public List<Student> selectAll(){
        return dao.selectAll();
    }
}
