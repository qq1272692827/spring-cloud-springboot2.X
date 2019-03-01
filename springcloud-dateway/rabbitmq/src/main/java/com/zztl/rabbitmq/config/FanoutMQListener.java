package com.zztl.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wenzhenyu
 * @description 消费者
 * @date 2019/1/9
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutMQListener {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("接受者  : " + hello);
    }

}
