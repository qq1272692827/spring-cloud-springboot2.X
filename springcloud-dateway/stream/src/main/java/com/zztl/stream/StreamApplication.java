package com.zztl.stream;


import com.zztl.stream.send.SendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.zztl.*")
@EnableBinding//(SendService.class)
public class StreamApplication extends SpringBootServletInitializer {

	private static Logger log = LoggerFactory.getLogger(StreamApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class,args);
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(StreamApplication.class);
	}





}
