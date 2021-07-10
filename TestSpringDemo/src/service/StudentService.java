package service;

import dao.StudentDao;
import domain.Student;
import util.MyUtil;

public class StudentService {
    private StudentDao dao = MyUtil.getMapper(StudentDao.class,true);
    public Student selectOne(Integer sid){

        return dao.selectOne(sid);
    }
}
