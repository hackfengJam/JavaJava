package com.interview.javabasic.reflect;

public class LoadDifference {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = Robot.class.getClassLoader();
        System.out.println("----------------");
        Class r = Class.forName("com.interview.javabasic.reflect.Robot");

    }
}
