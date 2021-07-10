package com.dpj.service.impl;

import com.dpj.dao.StudentDao;
import com.dpj.domain.Student;
import com.dpj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired(required = false)
    @Qualifier(value = "studentDaoImpl")
    private StudentDao studentDao;


    @Override
    public void regist(Student student) {
        System.out.println("StudentServiceImpl.regist---Service");
    }

    @Override
    public void login(String name, String password) {
        System.out.println("StudentServiceImpl.login---- Service");
    }

    @PostConstruct
    public void testPost(){
        System.out.println("StudentServiceImpl.testPost--- testPostAnnotation");
    }
}
