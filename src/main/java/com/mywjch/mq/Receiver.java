package com.mywjch.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues="hello")
public class Receiver {

    @RabbitHandler
    public void process(String content) {
        log.info("DemoConsumer: {}", content);
    }
}
