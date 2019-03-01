package com.zztl.testrocketmq.config;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;

/**
 * @author wenzhenyu
 * @description
 * @date 2019/1/9
 */
//@Component
    @Service
public class RocketMQClient {
    /**
     * 生产者的组名
     */
    @Value("${rocketmq.producer.groupName}")
    private String producerGroup;

    /**
     * NameServer 地址
     */
    @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;

//    @PostConstruct
    public void defaultMQProducer(String content) {
        //生产者的组名
        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        //指定NameServer地址，多个地址以 ; 隔开
        producer.setNamesrvAddr(namesrvAddr);

        try {
            /**
             * Producer对象在使用之前必须要调用start初始化，初始化一次即可
             * 注意：切记不可以在每次发送消息时，都调用start方法
             */
            producer.start();
            String msg = "需要发送的消息实体内容："+content;
            Message message = new Message("TopicTest", "push", msg.getBytes(RemotingHelper.DEFAULT_CHARSET));

//            StopWatch stop = new StopWatch();
//            stop.start();
//            for (int i = 0; i < 10000; i++) {
                SendResult result = producer.send(message);

//                System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
//
//            }
//            stop.stop();
//            System.out.println("----------------发送一万条消息耗时：" + stop.getTotalTimeMillis());
            System.out.println("发送完毕！" );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}
