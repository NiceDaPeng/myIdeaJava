package com.dpj.dao.impl;

import com.dpj.dao.PersonDao;
import com.dpj.domain.Person;

public class PersonDaoImpl implements PersonDao {


    @Override
    public void insert(Person person) {
        System.out.println("person = " + person);
    }

    @Override
    public void existsNames(String pname) {
        System.out.println("pname = " + pname);
    }

    @Override
    public Person selectByNameAndPassword(String name, String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return null;
    }
}
