package com.hero.demo.dubbocust.service;

import com.hero.demo.dubbocust.config.PropsConfig;
import com.hero.demo.dubbosvr.api.GreetingService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    private static Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    private PropsConfig propsConfig;

    public void initGreeting() {
        String zooHost = propsConfig.getZoo_host();
        int zooPort = propsConfig.getZoo_port();

        ReferenceConfig<GreetingService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zooHost + ":" + zooPort));
        reference.setInterface(GreetingService.class);
        GreetingService service = reference.get();
        String message = service.sayHi("dubbo");
        logger.info("message = {}", message);

    }
}
