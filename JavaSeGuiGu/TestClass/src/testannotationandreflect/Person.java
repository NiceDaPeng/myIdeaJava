package testannotationandreflect;

public class Person {

    private String name;
    private Integer age;
    private String sex;

    @MyAnnotation({"秦兰兰","18","女"})
    public Person() {

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
}
