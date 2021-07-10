package service;

import dao.StudentDao;
import domain.Student;
import util.MySpring;

import java.util.List;

public class StudentService {

    private StudentDao dao = MySpring.getBean("dao.StudentDao");
    //注册方法
    public void regist(Student student){
        dao.insert(student);
    }

    //修改方法
    public void update(Student student){
        dao.update(student);
    }

    //删除方法
    public void delete(Integer sid){
        dao.delete(sid);
    }

    //查询单条记录
    public Student selecOne(Integer sid){
        return dao.selectOne(sid);
    }

    //查询多条,排序
    public List<Student> selectAllByOrder(String flag){
        return dao.selectAllByOrder(flag);
    }
}
