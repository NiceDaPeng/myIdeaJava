package com.dpj.service;

import com.dpj.domain.Person;

public interface PersonService {

    void login(String username,String password);

    void regist(Person person);
}
