package service;

import dao.TeacherDao;
import domain.Teacher;

public class TeacherService {

    private TeacherDao dao = new TeacherDao();
    //给定一个老师的编号，查询老师的信息和他教的所有学生信息
    public Teacher selectOne(Integer tid){
        return dao.selectOne(tid);
    }
}
