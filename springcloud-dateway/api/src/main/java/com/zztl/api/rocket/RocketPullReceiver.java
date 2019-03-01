package com.zztl.api.rocket;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.impl.consumer.PullResultExt;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wenzhenyu
 * @description pull的方式拉取mq消息  有问题
 * @date 2019/1/10
 */
@Service
public class RocketPullReceiver {

    // TODO: 2019/1/10
    private static final Map<MessageQueue, Long> offsetTable = new HashMap<MessageQueue, Long>();

    /**
     * 消费者的组名
     */
    @Value("${rocketmq.producer.groupName}")
    private String consumerGroup;

    /**
     * NameServer 地址
     */
    @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;

    public void pullMQ()throws  Exception{
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer(consumerGroup);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.start();
        try {
            Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues("TopicTest");
            for(MessageQueue mq:mqs) {
                System.out.println("Consume from the queue: " + mq);
                //	long offset = consumer.fetchConsumeOffset(mq, true);
                //	PullResultExt pullResult =(PullResultExt)consumer.pull(mq, null, getMessageQueueOffset(mq), 32);
                //消息未到达默认是阻塞10秒，private long consumerPullTimeoutMillis = 1000 * 10;
                PullResultExt pullResult =(PullResultExt)consumer.pullBlockIfNotFound(mq, null, getMessageQueueOffset(mq), 32);
//                putMessageQueueOffset(mq, pullResult.getNextBeginOffset());
                switch (pullResult.getPullStatus()) {
                    case FOUND:
                        List<MessageExt> messageExtList = pullResult.getMsgFoundList();
                        for (MessageExt m : messageExtList) {
                            System.out.println(new String(m.getBody()));
                        }
                        break;
                    case NO_MATCHED_MSG:
                        break;
                    case NO_NEW_MSG:
                        break ;
                    case OFFSET_ILLEGAL:
                        break;
                    default:
                        break;
                }
            }
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }


    private static void putMessageQueueOffset(MessageQueue mq, long offset) {
        offsetTable.put(mq, offset);
    }


    private static long getMessageQueueOffset(MessageQueue mq) {
        Long offset = offsetTable.get(mq);
        if (offset != null)
            return offset;
        return 0;
    }




}
