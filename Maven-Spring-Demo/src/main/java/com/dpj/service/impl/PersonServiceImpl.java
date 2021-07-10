package com.dpj.service.impl;

import com.dpj.dao.PersonDao;
import com.dpj.domain.Person;
import com.dpj.service.PersonService;

public class PersonServiceImpl implements PersonService {

    private PersonDao dao ;

    public PersonDao getDao() {
        return dao;
    }

    public void setDao(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public void login(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }

    @Override
    public void regist(Person person) {
        System.out.println("person = " + person);
    }
}
