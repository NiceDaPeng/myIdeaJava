package test;

import dao.PersonDao;
import dao.dao.impl.PersonDaoImpl;
import domain.Person;
import util.BeanFactory;

public class TestMain {
    public static void main(String[] args) {

        Person person = (Person) BeanFactory.getBean("person");
        person.test();

        PersonDao dao = (PersonDao) BeanFactory.getBean("personDao");
        dao.test();

    }
}
