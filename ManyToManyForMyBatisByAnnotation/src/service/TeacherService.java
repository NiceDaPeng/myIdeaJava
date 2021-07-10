package service;

import dao.TeacherDao;
import domain.Teacher;
import util.MyUtil;

import java.util.List;

public class TeacherService {
    private TeacherDao dao = MyUtil.getMapper(TeacherDao.class,true);
    public Teacher selectOne(Integer tid){
        return dao.selectOne(tid);
    }

    //设计一个方法用来查询所有的老师的信息
    public List<Teacher> selectAll(){
       return dao.selectAll();
    }
}
