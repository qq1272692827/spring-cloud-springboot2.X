package com.zztl.testrocketmq.service;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wenzhenyu
 * @description pull方式发送
 * @date 2019/1/10
 */
@Service
public class RocketPullSender {


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

    public void sendMQ(String content) {
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
            Message message = new Message("TopicTest", "pull", msg.getBytes(RemotingHelper.DEFAULT_CHARSET));


            SendResult result = producer.send(message);


            System.out.println("发送完毕！" );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }




}
