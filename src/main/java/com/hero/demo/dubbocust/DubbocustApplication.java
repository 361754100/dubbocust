package com.hero.demo.dubbocust;

import com.hero.demo.dubbocust.threadpool.CommonTaskManager;
import com.hero.demo.dubbocust.threadpool.InitTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DubbocustApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubbocustApplication.class, args);

        InitTask initTask = new InitTask();
        CommonTaskManager.getInstance().addTask(initTask);
    }

}
