package com.hlam.track5.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    // Khai báo logger để ghi lại các thông tin log và lỗi trong quá trình nhận tin nhắn.

    @KafkaListener (topics = "javaguides", groupId = "myGroup")
    public void consume(String message ){
        LOGGER.info(String.format("Message received -> %s", message));
        // Ghi lại thông tin tin nhắn nhận được, sử dụng logger.
    }
}
