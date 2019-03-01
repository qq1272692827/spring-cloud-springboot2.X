package com.zztl.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wenzhenyu
 * @description topic Exchange队列
 * @date 2019/1/11
 */
@Configuration
public class TopicRabbitConfig  {

    final static String message = "topic.message";

    @Bean
    public Queue queueMessage(){
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bingExchangeMessage(Queue queueMessage,TopicExchange exchange  ){
        return BindingBuilder.bind(queueMessage).to(exchange).with(message);
    }


}
