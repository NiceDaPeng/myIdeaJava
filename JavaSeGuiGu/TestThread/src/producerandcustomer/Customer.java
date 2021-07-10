package producerandcustomer;

public class Customer extends Thread{

    public void run(){
        WareHouse house = WareHouse.getInstance();
        while (true) {
            house.get();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("取得了一个元素");
        }
    }
}
