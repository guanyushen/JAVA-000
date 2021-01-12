package com.guanys.kafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: kafka-demo
 * @PACKAGE_NAME: com.guanys.kafkademo
 * @NAME: KafkaConsumer
 * @Author: guanys
 * @DATE: 1/12/21:11:13 PM
 * @Description: TODO
 * @Version: 1.0
 **/
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"testk"})
    public void consume(String message){
        System.out.println("receive msg "+ message);
    }
}
