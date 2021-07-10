package dpj.testthread;

public class TestMain {

    public static void main(String[] args) {

        Factory factory = new Factory();
        factory.start();

        Customer c1 = new Customer();
        Customer c2 = new Customer();
        c1.start();
        c2.start();
    }
}
