package com.interview.javabasic.thread;

public class CycleWait implements Runnable {


    private String value;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we hava data now";
    }

    public static void main(String[] args) {
        CycleWait cw = new CycleWait();
        Thread t = new Thread(cw);
        t.start();
//        while (cw.value == null) { // 主线程等待法
//            try {
//                Thread.currentThread().sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        try { // join
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("value : " + cw.value);
    }
}
