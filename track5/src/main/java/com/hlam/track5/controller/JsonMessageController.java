package com.hlam.track5.controller;

import com.hlam.track5.kafka.JsonKafkaProducer;
import com.hlam.track5.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//REST controller
@RequestMapping("/api/v1/kafka/")
//định nghĩa các endpoint trong controller này, tất cả endpoint bắt đầu bằng /api/v1/kafka/
public class JsonMessageController {
    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    @PostMapping("/publish")
    //nhan yeu cau POST
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        //goi phuong thuc sendMessage trong kafakProducer để gửi đối tượng user đến Kafka
        return ResponseEntity.ok("Json message sent to kafka topic");
        //gửi tin nhắn Json đã được gửi tới topic

    }
}
