package com.xdclass.couponapp.service.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author William
 * @version 1.0
 * @description: TODO
 * @date 2020/11/30 8:56
 */
@Component
public class TestSchedule {

    //每 10 秒钟打印一次
    @Scheduled(cron = "0/10 * * * * ?")
    //每一分钟打印一次
   // @Scheduled(cron = "* 0/1 * * * ?")
    //每一小时打印一次
    // @Scheduled(cron = "* * 0/1 * * ?")
    public void test() {
        System.out.println("Hello World!");
    }
}
