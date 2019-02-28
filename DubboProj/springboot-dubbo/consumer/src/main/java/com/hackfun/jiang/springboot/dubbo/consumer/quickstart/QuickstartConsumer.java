package com.hackfun.jiang.springboot.dubbo.consumer.quickstart;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hackfun.jiang.springboot.dubbo.ServiceAPI;
import org.springframework.stereotype.Component;

@Component
public class QuickstartConsumer{

    @Reference(interfaceClass = ServiceAPI.class)
    private ServiceAPI serviceAPI;

    public void sendMessage(String message) {
        System.out.println(serviceAPI.sendMessage(message));
    }
}
