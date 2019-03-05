package com.interview.javabasic.bytecode;

public class ByteCodeSample {
    public static void main(String[] args) {
//        Class.forName();
        int i = 1, j = 5;
        i++;
        ++j;
        System.out.println(i);
        System.out.println(j);
    }
}
// javac com/hackfun/javabasic/bytecode/ByteCodeSample.java
// java com/hackfun/javabasic/bytecode/ByteCodeSample
// javap com/hackfun/javabasic/bytecode/ByteCodeSample.class