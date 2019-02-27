package com.hackfun.jiang.dubbo.quickstart;

import com.hackfun.jiang.dubbo.ServiceAPI;

public class QuickStartService implements ServiceAPI{
    @Override
    public String sendMessage(String message) {
        return "quickstart-provider-message=" + message;
    }
}
