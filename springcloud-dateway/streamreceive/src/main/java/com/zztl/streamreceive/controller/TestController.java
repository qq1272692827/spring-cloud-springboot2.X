package com.zztl.streamreceive.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenzhenyu
 * @description 测试
 * @date 2019/1/14
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "success";
    }

}
