package com.zztl.testrocketmq.controller;

import com.zztl.testrocketmq.config.RocketMQClient;
import com.zztl.testrocketmq.config.RocketMQServer;
import com.zztl.testrocketmq.service.RocketPullSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wenzhenyu
 * @description 控制层
 * @date 2019/1/9
 */
@RestController
public class RocketmqTestController {


    @Autowired
    RocketMQServer rocketMQServer;
    @Autowired
    RocketMQClient rocketMQClient;
    @Autowired
    RocketPullSender rocketPullSender;

    @RequestMapping("/testProd")
    public String testRocketmqProd(HttpServletRequest request){
        String content = request.getParameter("content");
        rocketMQClient.defaultMQProducer(content);
        return "rocketmq Test";
    }

    @RequestMapping("/tesPull")
    public String pullRocket(HttpServletRequest request){
        String content = request.getParameter("content");
        rocketPullSender.sendMQ(content);
        return "rocketmq Test";
    }


    @RequestMapping("/testCon")
    public String testRocketmqConsume(){
        rocketMQServer.defaultMQPushConsumer();
        return "rocketmq Test";
    }

}
