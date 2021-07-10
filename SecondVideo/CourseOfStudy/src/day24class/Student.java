package day24class;

import java.io.Serializable;

public class Student implements Serializable,Comparable{

    private static final long serialVersionUID = -212633175572640123L;

    private String name;
    private Integer age;
    private String sex;

    public Student() {
    }

    public Student(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student){
            Student stu1 = (Student)o;
            return this.getAge() - stu1.getAge();
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
