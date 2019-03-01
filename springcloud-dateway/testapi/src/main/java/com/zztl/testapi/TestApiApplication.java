package com.zztl.testapi;

import feign.Retryer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@MapperScan("com.zztl.testapi.dao")
@ComponentScan(basePackages = "com.zztl.*")
@EnableFeignClients
@EnableHystrix
public class TestApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TestApiApplication.class);
	}


	@Bean
	public Retryer feignRetryer() {
		return new Retryer.Default();
	}

}
