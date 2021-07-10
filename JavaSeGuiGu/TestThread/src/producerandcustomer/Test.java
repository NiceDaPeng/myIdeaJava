package producerandcustomer;

public class Test {

    public static void main(String[] args) {

        Customer cus1 = new Customer();
        Customer cus2 = new Customer();
        Producer pro = new Producer();

        cus1.start();
        cus2.start();
        pro.start();

    }
}
