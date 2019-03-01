package com.zztl.streamreceive.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface ReceiveService {

    @Input("test_stream_input")
    SubscribableChannel test_stream_input();

}
