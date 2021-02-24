package cn.sw.quartz;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
/**
 * https://blog.csdn.net/github_38151745/article/details/79224995
 * spring 3.0 后只支持 "6个参数" 的cron 把年去掉
 */

@Component
//@EnableScheduling
@EnableAsync        // 2.开启多线程
public class TestScheduler {

    @Scheduled(cron = "${cronTime1}")
    public void test1() {
        System.out.println("第3个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
    }


    @Async
    @Scheduled(fixedDelay = 100000)  //间隔1秒
    public void first() throws InterruptedException {
        System.out.println("第一个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
    }

    @Async
    @Scheduled(fixedDelay = 200000)
    public void second() {
        System.out.println("第二个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
    }
}
