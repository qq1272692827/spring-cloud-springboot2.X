package com.zztl.rabbitmq.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReceiveAndReplyCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wenzhenyu
 * @description 发送者
 * @date 2019/1/9
 */
@Component
public class PuslishSender implements RabbitTemplate.ConfirmCallback ,RabbitTemplate.ReturnCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String context = "发送的日期 " + new Date();
        System.out.println("Sender : " + context);

        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.convertAndSend("hello", context);

    }

    public void sendError() {
        String context = "发送的日期 " + new Date();
        System.out.println("Sender : " + context);

        this.rabbitTemplate.setReturnCallback(this);
//        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.convertAndSend("name", context);

    }

    public void topicSend(){
        String context = "试试看topic发送";
        System.out.println("发送者 : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void sendFanout(){
        String json = "Fanout发送的消息："+new Date();
        System.out.println("发送完毕!");
        rabbitTemplate.convertAndSend("fanoutExchange","",json);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String s) {
        if(!ack){
            System.out.println("收到的回应：==对应的布尔值=="+ack);
        }else{
            System.out.println("收到的回应："+ack+"==表示成功了");
        }

    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {

        System.out.println(" 返回的信息"+message+"==对应的串=="+s+"--s1--"+s1);
    }


}
