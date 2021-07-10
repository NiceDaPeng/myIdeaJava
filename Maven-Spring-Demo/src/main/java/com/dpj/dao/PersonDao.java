package com.dpj.dao;

import com.dpj.domain.Person;

public interface PersonDao {

    void insert(Person person);
    void existsNames(String pname);
    Person selectByNameAndPassword(String name,String password);
}
