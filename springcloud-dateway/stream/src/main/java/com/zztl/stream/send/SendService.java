package com.zztl.stream.send;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

/**
 *发送消息
 * @author wenzhenyu
 * @date 2019/1/14
 * @param  * @param null
 * @return
 */
public interface SendService {

    @Output("test_stream_input")
    SubscribableChannel send();

//    Sink.INPUT

}
