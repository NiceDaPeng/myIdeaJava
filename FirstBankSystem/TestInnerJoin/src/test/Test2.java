package test;

import domian.Emp;
import service.MySpring;

public class Test2 {

    public static void main(String[] args) {

        MySpring spring = new MySpring();
        Emp bean = spring.getBean("domian.Emp");
        bean.setEname("haha");
        System.out.println(bean.getEname());
    }
}
