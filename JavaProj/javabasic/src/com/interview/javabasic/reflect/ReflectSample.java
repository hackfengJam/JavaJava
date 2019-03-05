package com.interview.javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class rc = Class.forName("com.interview.javabasic.reflect.Robot");
        Robot r = (Robot) rc.newInstance();
        System.out.println("Class name is " + rc.getName());

        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
        getHello.setAccessible(true);// 因为是私有方法，因此设置为true
        Object str = getHello.invoke(r, "Bob");
        System.out.println("getHello result is " + str);

        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r, "Welcome");

        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r, "Alice");
        sayHi.invoke(r, "Welcome");

        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

    }
}
