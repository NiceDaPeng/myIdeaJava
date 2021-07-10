package com.dpj.dao.impl;

import com.dpj.dao.StudentDao;
import com.dpj.domain.Student;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {

    @Override
    public void save(Student student) {
        System.out.println("StudentDaoImpl.save --- DAO");
    }
}
