package com.zztl.api.controller;

import com.zztl.api.rocket.RocketPullReceiver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wenzhenyu
 * @description 测试
 * @date 2018/12/25
 */
@RestController
@RefreshScope
@RequestMapping("/api/")
public class TestController  {

    @Value("${test.name}")
    private String test;
    @Autowired
    RocketPullReceiver rocketPullReceiver;


    private Logger logger =  LogManager.getLogger(this.getClass());

    @RequestMapping(value =  "test" ,method = RequestMethod.GET)
    public String test(HttpServletRequest request){
        String header = request.getHeader("Hello");
        logger.info("调用了test方法");
//        int num =0;
//        int count = 3/num;
//        System.out.println("查看一下具体的值："+request.getRequestURL().toString()+"===="+request.getRequestURI() );
        return "api 接口下的：test name=="+test;

    }

    @RequestMapping("fallback")
    public String fallback(HttpServletRequest request){

        String header = request.getHeader("Hello");
        System.out.println("回退操作："+header );
        System.out.println("回退操作："+request.getRequestURL().toString()+"===="+request.getRequestURI() );
//        request.get
        return "fallback success=="+test;
    }



    @RequestMapping("pull")
    public String pull(){
        try{

            rocketPullReceiver.pullMQ();
        }catch (Exception e){
            e.printStackTrace();
        }

        return "fallback success==";
    }


}
