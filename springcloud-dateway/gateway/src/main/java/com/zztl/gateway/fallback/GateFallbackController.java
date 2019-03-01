package com.zztl.gateway.fallback;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wenzhenyu
 * @description 控制层熔断
 * @date 2018/12/26
 */

@RestController
public class GateFallbackController {


    @HystrixCommand(commandKey="authHystrixCommand")
    public String authHystrixCommand(){

        System.out.println("Hystrix熔断返回机制：" );
        return "fallback success==";
    }


    @RequestMapping("/fallback")
    public String fallback( ){



        System.out.println("回退操作：" );
        return "fallback success==";
    }


}
