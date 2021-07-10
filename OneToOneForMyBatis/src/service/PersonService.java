package service;

import dao.PersonDao;
import domain.Person;

import java.util.List;

public class PersonService {

    //设计一个方法用来查询单条记录
    private PersonDao dao = new PersonDao();
    public Person selectOne(Integer pid){
        return dao.selectOne(pid);
    }

    //设计一个方法用来查询多条记录
    public List<Person> selectAll(){
        return dao.selectAll();
    }
}
