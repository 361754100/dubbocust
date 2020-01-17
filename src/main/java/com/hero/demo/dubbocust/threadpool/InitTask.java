package com.hero.demo.dubbocust.threadpool;

import com.hero.demo.dubbocust.common.SpringContext;
import com.hero.demo.dubbocust.service.ConsumerService;

public class InitTask implements Runnable {
    @Override
    public void run() {
        ConsumerService consumerService = SpringContext.getBean(ConsumerService.class);
        consumerService.initGreeting();
    }
}
