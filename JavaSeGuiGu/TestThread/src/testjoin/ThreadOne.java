package testjoin;

public class ThreadOne extends Thread{

    @Override
    public void run(){
        System.out.println("Threadone--开始运行了");
        ThreadTwo two = new ThreadTwo();
        try {
            two.start();
            two.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Threadone--运行结束了");

    }
}
