package com.hackfun.jiang.springboot.dubbo.consumer.transaction;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hackfun.jiang.springboot.ServiceAPI;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {

//    @Reference(interfaceClass = ServiceAPI.class)
    @Autowired
    private ServiceAPI serviceAPI;

    /*
     * 把此函数当成总事务控制器*/
    @Compensable(confirmMethod = "confirmSendMessage", cancelMethod = "cancelSendMessage", asyncConfirm = true)
    public void sendMessage(String message) {

//        System.out.println("this is consumer sendMessage message=" + message);
//        System.out.println(serviceAPI.sendMessage(message));

        // 测试业务
        serviceAPI.saveOrder("001", message, "5");

        serviceAPI.isTrueSeats(message);

        serviceAPI.isNotSold(message);

    }

    public void confirmSendMessage(String message) {
        System.out.println("this is consumer confirmSendMessage message=" + message);
//        System.out.println(serviceAPI.sendMessage(message));
    }

    public void cancelSendMessage(String message) {
        System.out.println("this is consumer confirmSendMessage message=" + message);
//        System.out.println(serviceAPI.sendMessage(message));
    }
}
