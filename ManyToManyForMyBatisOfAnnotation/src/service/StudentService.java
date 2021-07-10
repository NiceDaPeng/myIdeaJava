package service;

import dao.StudentDao;
import domain.Student;
import util.MyUtil;

import java.util.List;

public class StudentService {
    private StudentDao dao = MyUtil.getMapper(StudentDao.class,true);
    //设计一个方法根据员工的编号查询员工的信息以及所报老师的信息
    public Student selectOne(Integer sid){
        return dao.selectOne(sid);
    }

    //设计一个方法用来查询所有的学生信息以及所报课程老师的信息
    public List<Student> selectAll(){
        return dao.selectAll();
    }

    //设计一个方法根据编号或者是学生的姓名查询学生的信息
    public List<Student> selectStudentByDynamic(Integer sid,String sname){
        return dao.selectDynamic(sid, sname);
    }
}
