package com.interview.javabasic.thread;

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable mr1 = new MyRunnable("MyRunnable1");
        MyRunnable mr2 = new MyRunnable("MyRunnable2");
        MyRunnable mr3 = new MyRunnable("MyRunnable3");
        Thread mt1 = new Thread(mr1);
        Thread mt2 = new Thread(mr2);
        Thread mt3 = new Thread(mr3);
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
