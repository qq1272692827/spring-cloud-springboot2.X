package com.zztl.api.rabbitmq;

import com.zztl.rabbitmq.vo.UserVo;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wenzhenyu
 * @description 监听rabbitmq
 * @date 2019/1/10
 */
@Component
@RabbitListener(queues = "hello")
public class RabbitmqReceiver {
        @RabbitHandler
        public void process(UserVo user) {
            System.out.println("Receiver  : " + user.getUsername()+"----"+user.getGender());
        }

}
