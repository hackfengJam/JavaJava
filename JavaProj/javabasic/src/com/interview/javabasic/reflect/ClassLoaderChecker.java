package com.interview.javabasic.reflect;

public class ClassLoaderChecker {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader m = new MyClassLoader("G:/MyProgramFiles/JavaJava/JavaProj/", "myClassLoader");
        Class c = m.loadClass("Wali");
        System.out.println(c.getClassLoader());
        c.newInstance(); // 不支持传入参数

        // 尝试感受双亲委派效果
        System.out.println(c.getClassLoader().getParent()); // sun.misc.Launcher$AppClassLoader@b4aac2
        System.out.println(c.getClassLoader().getParent().getParent()); // sun.misc.Launcher$ExtClassLoader@17327b6
        System.out.println(c.getClassLoader().getParent().getParent().getParent()); // null


    }
}
