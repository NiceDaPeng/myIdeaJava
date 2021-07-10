package testjoin;

public class ThreadTwo extends Thread {

    public void run(){
        System.out.println("Threadtwo--开始运行了");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Threadtwo--运行完毕了");
    }
}
