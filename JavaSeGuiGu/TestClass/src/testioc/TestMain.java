package testioc;

public class TestMain {

    public static void main(String[] args) {

        MySpring ms = new MySpring();
        Person p = (Person)ms.getBean("testioc.Person");
        System.out.println(p);
    }
}
