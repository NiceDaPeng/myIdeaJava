package simulationtickets;

public class Window extends Thread {

    private String windowName;

    public Window(String windowName){
        this.windowName = windowName;
    }

    public void run(){
        sellTicket();
    }

    public void sellTicket(){

        while (true){

            System12306 sys = System12306.getInstance();
            Ticket ticket = sys.getTicket();

            if (ticket == null){

                System.out.println("对不起"+windowName+"窗口车票已经卖完了");
                break;
            }
            System.out.println("从"+windowName+"号窗口售出"+ticket);
        }
    }
}
