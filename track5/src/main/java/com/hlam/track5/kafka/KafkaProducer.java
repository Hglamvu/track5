package com.hlam.track5.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    // Khai báo logger để ghi lại các thông tin log và lỗi trong quá trình gửi tin nhắn.
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //phuong thuc gui tin nhan den kafka
    public void sendMessage(String message){
        // Ghi lại thông tin tin nhắn trước khi gửi, sử dụng logger.
        LOGGER.info(String.format("Message sent %s", message));
        //gửi message đến topic javaguides
        kafkaTemplate.send("javaguides",message);
    }
}
