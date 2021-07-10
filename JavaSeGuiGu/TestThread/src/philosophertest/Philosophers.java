package philosophertest;

public class Philosophers extends Thread{

    private Chopsticks left;
    private Chopsticks right;
    private String name;
    private long time;

    public Philosophers (String name,Chopsticks left,Chopsticks right,long time){
        this.name = name;
        this.left = left;
        this.right = right;
        this.time = time;
    }



    @Override
    public void run() {
        try {
            Thread.sleep(this.time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (left){

            System.out.println(this.name+"拿到了"+left.getName()+"号筷子");
            synchronized (right){
                System.out.println(this.name + "拿到了"+right.getName()+"号筷子");
                System.out.println(this.name+"吃完了");
            }
        }
    }
}
