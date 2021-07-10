package producerandcustomer;

public class Producer extends Thread{



    public void run(){
        WareHouse house = WareHouse.getInstance();
        while (true) {
            house.add();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("加入了一个元素");
        }
    }
}
