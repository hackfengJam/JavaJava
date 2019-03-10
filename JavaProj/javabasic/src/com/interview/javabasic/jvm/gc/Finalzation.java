package com.interview.javabasic.jvm.gc;

public class Finalzation {
    public static Finalzation finalzation;

    @Override
    protected void finalize() {
        System.out.println("Finalized");
        finalzation = this;
    }

    public static void main(String[] args) {
        Finalzation f = new Finalzation();
        System.out.println("First print: " + f);
        f = null;
        System.gc();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Second print: " + f);
        System.out.println(f.finalzation);


    }
}
