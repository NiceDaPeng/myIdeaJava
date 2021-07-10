package producerandcustomer;

import java.util.ArrayList;

public class WareHouse {

    private static WareHouse house = new WareHouse();
    private ArrayList<String> list = new ArrayList<>();

    private WareHouse(){

    }

    public static WareHouse getInstance(){
        return house;
    }

    public synchronized void add(){
        int i = 0;
        if (list.size() < 20){
            list.add("a");
        } else {
            try {
                this.notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void get(){
        if (list.size() > 0){
            list.remove(0);
        } else {
            try {
                this.notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
