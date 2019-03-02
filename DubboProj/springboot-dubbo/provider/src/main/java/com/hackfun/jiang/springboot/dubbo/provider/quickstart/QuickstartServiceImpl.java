package com.hackfun.jiang.springboot.dubbo.provider.quickstart;

import com.alibaba.dubbo.config.annotation.Service;
import com.hackfun.jiang.springboot.ServiceAPI;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = ServiceAPI.class)
public class QuickstartServiceImpl implements ServiceAPI{
    @Override
    public String sendMessage(String message) {
        return "quickstart-provider-message="+message;
    }
}
