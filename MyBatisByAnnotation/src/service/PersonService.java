package service;

import dao.PersonDao;
import domain.Person;
import util.MyUtil;

import java.util.List;

public class PersonService {
    private PersonDao dao = MyUtil.getMapper(PersonDao.class,true);

    public Person selectOne(Integer pid){
        return dao.selectOne(pid);
    }

    public List<Person> selectAll(){
        return dao.selectAll();
    }
}
