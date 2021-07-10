package testannotationandreflect;

public class TestMain {

    public static void main(String[] args) {

        MySpring ms = new MySpring();
        Person p = (Person)ms.getBean("testannotationandreflect.Person");
        System.out.println(p.getName()+"--"+p.getAge());
    }
}
