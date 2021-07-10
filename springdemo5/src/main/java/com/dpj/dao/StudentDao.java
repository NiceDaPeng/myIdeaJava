package com.dpj.dao;

import com.dpj.domain.Student;

import java.util.List;

public interface StudentDao {

    //增加学生信息
    void save(Student student);


    //查询所有员工信息
    List<Student> findAll();


}
