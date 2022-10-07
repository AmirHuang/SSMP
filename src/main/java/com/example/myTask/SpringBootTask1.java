package com.example.myTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class SpringBootTask1 {

    @Scheduled(cron = "0/59 * * * * ?")
    public void print1(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("springtask run ........" + simpleDateFormat.format(date));
    }
}
