package com.dpj.dao.impl;

import com.dpj.dao.StudentDao;
import com.dpj.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public void save(Student student) {
        System.out.println("StudentDaoImpl.save  ---- Dao层的save方法");
        System.out.println("student = " + student);
    }

    @Override
    public List<Student> findAll() {
        System.out.println("StudentDaoImpl.findAll---Dao层的findAll方法");
        return null;
    }
}
