package iocdemo;

import testiocdi.Person;

public class Test {
    public static void main(String[] args) {

        MyClass mc = new MyClass();
        Person p = (Person)mc.getBean("testiocdi.Person");
        System.out.println(p);
    }
}
