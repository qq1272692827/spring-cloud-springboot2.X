package com.zztl.testapi.remote;

import com.zztl.testapi.remote.impl.RemoteApiImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "api",fallback= RemoteApiImpl.class )
public interface RemoteApi {

    @RequestMapping(value = "api/test", method = RequestMethod.GET)
    public String remoteTest();


    @RequestMapping(value = "api/fallback", method = RequestMethod.GET)
    public String remoteFallback();


}
