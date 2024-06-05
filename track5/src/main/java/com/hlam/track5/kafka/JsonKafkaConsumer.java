package com.hlam.track5.kafka;

import com.hlam.track5.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    // Khai báo logger để ghi log khi nhận tin nhắn.
    @KafkaListener(topics = "javaguides_json",groupId = "myGroup")
    // Khi có tin nhắn mới được gửi tới topic javaguides_json, phương thức này sẽ được gọi.
    public void consume(User user){
        LOGGER.info(String.format("Json message received -> %s",user.toString()));
        // Ghi log thông tin về tin nhắn đã nhận được.
    }
}
