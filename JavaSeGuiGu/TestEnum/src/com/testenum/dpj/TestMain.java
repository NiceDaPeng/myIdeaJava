package com.testenum.dpj;

public class TestMain {

    public static void main(String[] args) {

        TestThread tt = new TestThread();
        Thread t1 = new Thread(tt);
        t1.start();

        TestThread tt1 = new TestThread();
        Thread t2 = new Thread(tt1);
        t2.start();
    }
}
