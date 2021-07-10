package service;

import dao.StudentDao;
import domain.Student;

public class StudentService {
    private StudentDao  dao = new StudentDao();
    //设计一个方法用来新增员工
    public void insertStudent(Student student){
        //判断当前更新的人是否冲突，成功存，不成功不存

        dao.insert(student);
    }
}
