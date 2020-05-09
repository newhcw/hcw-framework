package com.hcw.framework.kafka.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafaConsumer {

    private   Logger logger = LoggerFactory.getLogger(KafkaProducer.class);


    @KafkaListener(topics = "${topicName.topic1}")
    public void listen(String data) {
        logger.info("接受了一条消息:"+data);
    }
}
