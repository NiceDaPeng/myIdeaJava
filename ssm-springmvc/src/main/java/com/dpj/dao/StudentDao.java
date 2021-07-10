package com.dpj.dao;

import com.dpj.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    List<Student> findAll();
}
