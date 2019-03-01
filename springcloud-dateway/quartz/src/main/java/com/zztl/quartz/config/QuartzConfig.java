package com.zztl.quartz.config;

import com.zztl.quartz.task.DayJobTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wenzhenyu
 * @description 定式任务配置
 * @date 2019/1/17
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(DayJobTask.class).withIdentity("dayTask").storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("dayTask")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
