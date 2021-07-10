package com.dpj.service.impl;

import com.dpj.dao.StudentDao;
import com.dpj.domain.Student;
import com.dpj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao dao ;

    @Override
    public void save(Student student) {
        System.out.println("StudentServiceImpl.save --- Service层的save方法");
    }

    @Override
    public List<Student> findAll() {

        System.out.println("StudentServiceImpl.findAll ---- Service层的findAll方法");
        return null;
    }
}
