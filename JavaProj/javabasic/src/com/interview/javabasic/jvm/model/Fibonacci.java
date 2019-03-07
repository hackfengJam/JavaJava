package com.interview.javabasic.jvm.model;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
//        System.out.println(fibonacci(100));

        //
        String s3 = new String("a") + new String("a");
        s3.intern();
        String s4 = new String("aa");
        String s5 = "aa";
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
    }
}
