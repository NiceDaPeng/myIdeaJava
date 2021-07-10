package testiocdi;

public class TestMain {

    public static void main(String[] args) {
        MySpringone ms = new MySpringone();
        Person p = (Person)ms.getBean("testiocdi.Person");
        System.out.println(p);
    }
}
