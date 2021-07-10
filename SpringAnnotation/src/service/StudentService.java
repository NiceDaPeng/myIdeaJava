package service;

import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentService {
    @Autowired
    private StudentDao dao;
    public List<Map<String, Object>> select(String ssex){
        System.out.println("我是service层我执行了");
        return dao.select(ssex);
    }
}
