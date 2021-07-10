package testclassdemo;

import java.io.Serializable;

public class Person implements Serializable,Comparable{

    private String name;
    private int age;

    public Person(){

    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String toString(){
        return this.name+","+this.age;
    }
}
