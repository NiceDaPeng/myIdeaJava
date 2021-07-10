package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.StudentService;

import java.util.List;
import java.util.Map;


@Controller("studentController")
public class StudentController {
    @Autowired
    private StudentService service;
    public List<Map<String, Object>> select(String ssex){
        System.out.println("我是controller我执行了");
        return service.select(ssex);
    }
}
