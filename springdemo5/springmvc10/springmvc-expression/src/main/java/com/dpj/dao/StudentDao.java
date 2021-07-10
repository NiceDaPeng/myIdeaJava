package com.dpj.dao;

import com.dpj.domain.Student;

public interface StudentDao {

    //设计一个方法用来查询单个信息
    Student selectOne(Integer sid);
}
