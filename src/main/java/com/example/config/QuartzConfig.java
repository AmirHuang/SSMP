package com.example.config;

import com.example.quartz.Myquartz;
import lombok.Data;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail(){
        // 绑定具体的工作
        return JobBuilder.newJob(Myquartz.class).storeDurably().build();
    }

    @Bean
    public Trigger printJobTrigger(){
        ScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/59 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(scheduleBuilder).build();
    }
}
