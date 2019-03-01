package com.zztl.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wenzhenyu
 * @description topic Exchange队列
 * @date 2019/1/11
 */
@Configuration
public class FanoutRabbitConfig {

    final static String queueA = "fanout.A";

    @Bean
    public Queue AQueue(){
        return new Queue(FanoutRabbitConfig.queueA);
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange",true,true);
    }

    @Bean
    Binding bingExchangeMessage(Queue AQueue,FanoutExchange fanoutExchange  ){
        return BindingBuilder.bind(AQueue).to(fanoutExchange);
    }


}
