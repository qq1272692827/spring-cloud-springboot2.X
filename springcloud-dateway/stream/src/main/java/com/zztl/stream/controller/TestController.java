package com.zztl.stream.controller;

import com.zztl.stream.send.SendService;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author wenzhenyu
 * @description 测试
 * @date 2019/1/11
 */
@RestController
public class TestController {
//    private Logger log = LogFactory.getLog(TestController.class);

    @Autowired
    SendService sendService;

    @RequestMapping("/test")
    public String test(){


        String msg = "要发送的消息的主题内容";
        try{
            SubscribableChannel channel =  sendService.send();
            Message message = MessageBuilder.withPayload(msg.getBytes("utf-8")).build();
            channel.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("打印出消息");

        return "test stream";
    }

}
