package service;

import dao.StudentDao;
import domain.Student;
import util.MyUtil;

import java.util.List;

public class StudentService {

    //需要一个dao层对象支持
    StudentDao  dao = MyUtil.getMapper(StudentDao.class,true);
    //设计一个业务方法
    public void delete(Integer sid){
        dao.delete(sid);
    }

    //设计一个业务方法，新增
    public void insert(Student student){
        dao.insert(student);
    }

    //设计一个业务方法 修改
    public void update(Student student){
        dao.update(student);
    }

    //设计一个方法用来查询单个学生信息
    public Student selectOne(Integer sid){
        return dao.selectOne(sid);
    }

    //设计一个方法用来查询所有信息
    public List<Student> selectAll(){
        return dao.selectAll();
    }
}
