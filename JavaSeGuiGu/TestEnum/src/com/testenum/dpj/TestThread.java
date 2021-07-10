package com.testenum.dpj;

public class TestThread implements Runnable {
    @Override
    public void run() {
        TestEnum.testThread();
    }
}
