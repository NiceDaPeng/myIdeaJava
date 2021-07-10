package philosophertest;

public class TestMain {

    public static void main(String[] args) {

        Chopsticks c1 = new Chopsticks("1");
        Chopsticks c2 = new Chopsticks("2");
        Chopsticks c3 = new Chopsticks("3");
        Chopsticks c4 = new Chopsticks("4");

        Philosophers p1 = new Philosophers("哲学家1",c2,c1,0);
        Philosophers p2 = new Philosophers("哲学家2",c3,c2,2000);
        Philosophers p3 = new Philosophers("哲学家3",c4,c3,0);
        Philosophers p4 = new Philosophers("哲学家4",c1,c4,2000);

        p1.start();
        p2.start();
        p3.start();
        p4.start();

    }
}
