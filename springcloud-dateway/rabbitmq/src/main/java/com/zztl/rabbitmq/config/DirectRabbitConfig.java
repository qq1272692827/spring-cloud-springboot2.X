package com.zztl.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wenzhenyu
 * @description 配置
 * @date 2019/1/9
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }



}
