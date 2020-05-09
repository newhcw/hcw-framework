package com.hcw.framework.kafka.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducer{

    private  Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> template;


    public void sendMsg(String topic,String msg){
        template.send(topic,msg).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.error("kafka发生失败",throwable);
            }

            @Override
            public void onSuccess(SendResult<String, String> stringSendResult) {
                logger.info(String.valueOf(stringSendResult));
            }
        });


    }
}
