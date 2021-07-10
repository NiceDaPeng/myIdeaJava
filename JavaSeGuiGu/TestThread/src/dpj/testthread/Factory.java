package dpj.testthread;

public class Factory  extends Thread{
    public static Integer count = 5;
    @Override
    public void run() {
        while (true) {
            if (count <= 0) {
                System.out.println("生产者生产了一个苹果");
                count++;
            }
        }
    }
}
