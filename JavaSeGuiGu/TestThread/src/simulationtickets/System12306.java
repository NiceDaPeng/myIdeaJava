package simulationtickets;

import java.util.Vector;

public class System12306{

    private static System12306 sys = new System12306();

   private Vector<Ticket> vector = new Vector<>();
    {
        for (int i = 10; i <= 100; i++){
            vector.add(new Ticket("北京"+i,"深圳"+i,((i/5+5)*20F)));
        }
    }

    private System12306(){
    }

    public static System12306 getInstance(){
        return sys;
    }
    //设计一个方法用来对票进行减少
    public Ticket getTicket(){
        try {
            return vector.remove(0);
        } catch (Exception e){
            return null;
        }
    }

}
