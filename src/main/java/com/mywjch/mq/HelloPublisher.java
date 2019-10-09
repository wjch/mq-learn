package com.mywjch.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1)
public class HelloPublisher implements ApplicationRunner {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.warn("DemoPublisher: 启动");
        asyncSend();
    }
    @Async
    void asyncSend() {
        for (int i = 0; i < 1000; i++) {
            String context = "demo," + i;
//            log.info("DemoPublisher: {}",context);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.rabbitTemplate.convertAndSend("hello", context);
        }
    }
}
