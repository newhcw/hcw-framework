package com.hcw.framework.kafka;


import com.hcw.framework.kafka.core.KafkaProducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTest {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Value("topicName.topic1")
    private String topic ;

    @Test
    public void sendMsg(){
        kafkaProducer.sendMsg(topic,"hello boy!!");
    }
    
}