package com.sync.schedule;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
//如果嫌xml配置麻烦可以直接使用下面这个注解实现配置
//@EnableScheduling
@Lazy(value = false)
public class TestSchedule {
        private int count = 0;
        //@Scheduled(cron = "0/5 * * * * ?")
        public void testScheduled() {
            count += 1;
            System.out.println(getClass() + "执行了定时任务！次数："+count);
        }
    }

