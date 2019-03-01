package com.zztl.task;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.zztl.*")
@EnableScheduling
public class TaskApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TaskApplication.class);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return new HelloWorldCommandLineRunner();
	}

	public static class HelloWorldCommandLineRunner implements CommandLineRunner {
		public void run(String... strings) throws Exception {
			System.out.println("在看看具体的情况---Hello World!");
		}
	}






}
