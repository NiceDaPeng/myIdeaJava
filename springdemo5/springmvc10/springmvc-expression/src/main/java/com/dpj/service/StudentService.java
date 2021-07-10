package com.dpj.service;

import com.dpj.dao.StudentDao;
import com.dpj.domain.Student;
import com.dpj.utils.MyUtil;

public class StudentService {

    private StudentDao dao = MyUtil.getMapper(true,StudentDao.class);

    //设计一个方法用来查询单个学生信息
    public Student selectOne(Integer sid){
        return dao.selectOne(1);
    }
}
