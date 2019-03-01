package com.zztl.rabbitmq.controller;

import com.zztl.rabbitmq.config.PuslishSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenzhenyu
 * @description
 * @date 2019/1/9
 */
@RestController
public class RabbitmqTestController {

    @Autowired
    PuslishSender puslishSender;

    @RequestMapping("/test")
    public String testRabbitmq(){
        puslishSender.send();
        return "test rabbitmq";
    }

    @RequestMapping("/testError")
    public String testRabbitmqError(){
        puslishSender.sendError();
        return "test rabbitmq error";
    }


    @RequestMapping("/testTopic")
    public String receiveRabbitmq(){
        puslishSender.topicSend();
        return "test rabbitmq";
    }

    @RequestMapping("/testFanout")
    public String testFanoutRabbitmq(){
        puslishSender.sendFanout();
        return "test rabbitmq";
    }




}
