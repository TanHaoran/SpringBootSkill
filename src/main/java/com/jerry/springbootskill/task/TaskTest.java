package com.jerry.springbootskill.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskTest {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 定时每隔3秒执行任务
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() {
        System.out.println("现在时间:" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "4-40 * * * * ? ")
    public void reportCurrentTimeByCron() {
        System.out.println("现在时间:" + dateFormat.format(new Date()));
    }
}