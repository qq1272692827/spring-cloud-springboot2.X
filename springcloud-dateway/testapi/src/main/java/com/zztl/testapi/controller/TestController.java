package com.zztl.testapi.controller;


import com.zztl.testapi.dao.zzkj_user.UserMapper;
import com.zztl.testapi.remote.RemoteApi;
import com.zztl.testapi.vo.StudentVo;
import com.zztl.testapi.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author wenzhenyu
 * @description 测试
 * @date 2018/12/29
 */
@RestController
public class TestController {

    @Autowired
    UserMapper userMapper;
//    @Autowired
//    StudentMapper studentMapper;
    @Autowired
    RemoteApi remoteApi;

    @RequestMapping("/saveStudent")
    public String saveStudent(){

//        StudentVo studentVo = new StudentVo();
//        studentVo.setSname(System.currentTimeMillis()+"");
//        studentVo.setGender(0);
//        studentMapper.saveStudent(studentVo);
        return "student success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(){

        UserVo userVo = new UserVo();
        userVo.setUsername(System.currentTimeMillis()+"");
        userVo.setPassword(new Date().toString());
        userMapper.saveUser(userVo);
        return "user success";

    }

    @RequestMapping("/test")
    public String test(){

//        Map<String,String> result = userMapper.getUserInfo();
//        for (Map.Entry<String,String> entry: result.entrySet() ) {
//
//            System.out.println(entry.getKey()+"---"+entry.getValue());
//
//        }


        return "test success";

    }


    @RequestMapping("/feign")
    public String feign(){

        return remoteApi.remoteTest();

    }


    @RequestMapping("/call")
    public String call(){

        return remoteApi.remoteFallback();

    }



}
