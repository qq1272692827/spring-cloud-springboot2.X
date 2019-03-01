package com.zztl.task.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenzhenyu
 * @description 测试
 * @date 2019/1/17
 */
@RestController
public class TestControlelr {

    @RequestMapping("/test")
    public String test(){

        return "success";
    }

}
