package com.hlam.track5.kafka;

import com.hlam.track5.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
     private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

     private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    //phuong thuc sendMessgage: gui tin nhan den user
    public void sendMessage (User data ){
        LOGGER.info(String.format("Message sent -> %s", data.toString()));
        // Tạo  Message với dữ liệu của user và topic là javaguides_json
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"javaguides_json")
                .build();

        kafkaTemplate.send(message);
    }
}
