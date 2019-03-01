package com.zztl.task.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wenzhenyu
 * @description 定时任务
 * @date 2019/1/17
 */
@Component
public class ScheduleTash {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

//    @Scheduled(fixedRate = 1000)
//    public void testFixRate() {
//        System.out.println("每隔1秒执行一次：" + dateFormat.format(new Date()));
//    }

    @Scheduled( cron = "0 * * * * ?" )
    public void timeTaskExecute(){
        System.out.println(" 看一下是怎么执行的" + dateFormat.format(new Date())  );
    }


    public static void main(String[] args){
//        System.out.println(Integer.m);
    }


}
