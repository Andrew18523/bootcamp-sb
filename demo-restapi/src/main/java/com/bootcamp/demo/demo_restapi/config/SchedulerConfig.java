package com.bootcamp.demo.demo_restapi.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component // 要係 DemoRestapiApplication 度加 @EnableScheduling
public class SchedulerConfig {
  //@Scheduled(fixedDelay = 5000) //5000ms = 5s, 開一支新THREAD 去每5秒做一次 //start-> 6 sec -> end -> 5 sec -> start -> ......
  public void sayHello() throws Exception{
    System.out.println("Task A: Hello! start time=" +System.currentTimeMillis());
    Thread.sleep(6000);
    System.out.println("Task A: Hello! end time=" +System.currentTimeMillis());
  }

  // @Scheduled(fixedRate = 3000) // fixrate = 每XXXXMS開始一次，因為FIXRATE< SLEEP。想要開始果陣，
                                //個THREAD仲SLEEP 緊。逼住要等上一個OPERATION 返來再開始
  public void sayGoodBye() throws Exception{
    System.out.println("Task B: Goodbay! start time="+ System.currentTimeMillis());
    Thread.sleep(7000);
    System.out.println("Task B: Goodbay! end time="+ System.currentTimeMillis());
  }

  @Scheduled (cron = "0 56 8,20 * * TUE-WED")
  public void runTask(){
    System.out.println("Cron Job");
  }
}
