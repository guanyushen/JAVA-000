package com.guanys.activemqdemo;

import org.springframework.jms.annotation.JmsListener;

/**
 * @PROJECT_NAME: activemq-demo
 * @PACKAGE_NAME: com.guanys.activemqdemo
 * @NAME: Consumer
 * @Author: guanys
 * @DATE: 1/12/21:11:40 PM
 * @Description: TODO
 * @Version: 1.0
 **/
public class Consumer {

    //queue模式的消费者
    @JmsListener(destination = "test-queue", containerFactory = "jmsListenerContainerQueue")
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }

    //topic模式的消费者
    @JmsListener(destination = "test-topic", containerFactory = "jmsListenerContainerTopic")
    public void readActiveTopic(String message) {
        System.out.println("topic接受到：" + message);
    }
}
