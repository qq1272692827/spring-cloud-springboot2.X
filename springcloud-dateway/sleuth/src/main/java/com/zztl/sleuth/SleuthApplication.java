package com.zztl.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import zipkin.server.internal.EnableZipkinServer;


@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.zztl.*")
@EnableZipkinServer
public class SleuthApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		args = new String[1];
		args[0] = "--spring.profiles.active=zipkin-http";
		SpringApplication.run(SleuthApplication.class, args);
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SleuthApplication.class);
	}


}
