package com.interview.javabasic.jvm.gc;

public class ReferenceCounterProblem {
    public static void main(String[] args) {
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();

        myObject1.childNode = myObject2;
        myObject2.childNode = myObject1;

    }
}
