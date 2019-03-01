package com.zztl.streamreceive;


import com.zztl.streamreceive.config.ReceiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.zztl.*")
@EnableBinding(ReceiveService.class)
public class StreamReceiveApplication extends SpringBootServletInitializer {

	private static Logger log = LoggerFactory.getLogger(StreamReceiveApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StreamReceiveApplication.class, args);
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(StreamReceiveApplication.class);
	}



	@StreamListener("test_stream_input")
	public void onReceive(byte[] bytes){
		System.out.println("接收到的消息："+ new String( bytes ) );
	}


}
