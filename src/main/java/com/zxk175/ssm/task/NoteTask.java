package com.zxk175.ssm.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zxk175 on 2017/2/22.
 */
@Component
@EnableScheduling
public class NoteTask {
    private String date;

    private String formatDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 每5秒执行一次
     */
    @Scheduled(cron = "*/5 * * * * ?")
    public void show() {
        date = formatDate();
        //System.out.println("Annotation：is show run time：" + date);
    }
}
