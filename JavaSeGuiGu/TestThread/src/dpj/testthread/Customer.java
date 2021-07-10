package dpj.testthread;

public class Customer extends Thread {

    @Override
    public void run() {
        while (true){
            if (Factory.count >0) {
                Factory.count--;
                System.out.println("消费者买了一个苹果");
            }
        }
    }
}
