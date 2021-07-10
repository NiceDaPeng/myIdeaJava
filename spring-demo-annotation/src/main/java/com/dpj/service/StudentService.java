package com.dpj.service;

import com.dpj.domain.Student;

public interface StudentService {

    void regist(Student student);

    void login(String name,String password);
}
