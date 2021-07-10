package com.dpj.service;

import com.dpj.domain.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);

    List<Student> findAll();
 }
