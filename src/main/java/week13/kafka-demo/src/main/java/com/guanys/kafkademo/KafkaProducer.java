package com.guanys.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: kafka-demo
 * @PACKAGE_NAME: com.guanys.kafkademo
 * @NAME: KafkaProducer
 * @Author: guanys
 * @DATE: 1/12/21:11:13 PM
 * @Description: TODO
 * @Version: 1.0
 **/

@RestController
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 发送消息
    @GetMapping("/kafka/normal/{message}")
    public void product(@PathVariable("message") String normalMessage) {
        kafkaTemplate.send("testk", normalMessage);
    }

}
