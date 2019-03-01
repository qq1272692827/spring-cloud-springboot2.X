package com.zztl.gateway;

import com.zztl.gateway.filter.RequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring could conf程序主入口
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.zztl.*")
public class GatewayApplication {// extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/**")
                        .filters(f -> f.filter(new RequestFilter()).addRequestHeader("Hello","带到header中的值")
                                .addResponseHeader("Hello","The value of Hello in the response header")
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar")
                        )
                        .uri("lb://api")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
    }




}
