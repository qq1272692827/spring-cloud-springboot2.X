package com.zztl.testapi.remote.impl;

import com.zztl.testapi.remote.RemoteApi;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wenzhenyu
 * @description 远程调用api
 * @date 2019/1/3
 */
@Component
public class RemoteApiImpl implements  RemoteApi{


    public String remoteTest(){
        return "中途的问题出现了";
    }


    public String remoteFallback(){
        return "调用fallback 出问题";
    }


}
//@Component
//public class RemoteApiImpl implements FallbackFactory<RemoteApi> {
//    @Override
//    public RemoteApi create(Throwable throwable) {
//        return new  RemoteApi() {
//            @Override
//            public String remoteTest() {
//                return "远程调用失败的处理";
//            }
//        };
//    }
//}
