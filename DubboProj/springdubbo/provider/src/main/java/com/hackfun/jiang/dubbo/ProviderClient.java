package com.hackfun.jiang.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext content = new ClassPathXmlApplicationContext("applicationContext-hello.xml");

        content.start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
