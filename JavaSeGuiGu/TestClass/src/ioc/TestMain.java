package ioc;

public class TestMain {

    public static void main(String[] args) {

        MySpring ms = new MySpring();
        Person ques =(Person) ms.getBean("ioc.Person");
        System.out.println(ques);
    }
}
