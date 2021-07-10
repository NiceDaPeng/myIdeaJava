package dpj.testthread;

public class Test {

    public static void main(String[] args) {

//        Windows w = new Windows("窗口1");
//        Windows w1 = new Windows("窗口2");
//
//        w.start();
//        w1.start();

        ThreadDemo1 td = new ThreadDemo1("线程1");
        ThreadDemo1 td1 = new ThreadDemo1("线程2");

        Thread t1 = new Thread(td);
        Thread t2 = new Thread(td1);

        t1.start();
        t2.start();
    }
}
