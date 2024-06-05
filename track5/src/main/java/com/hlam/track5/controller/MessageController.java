    package com.hlam.track5.controller;

    import com.hlam.track5.kafka.KafkaProducer;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/v1/kafka")
    //định nghĩa các endpoint trong controller này, tất cả endpoint bắt đầu bằng /api/v1/kafka/

    public class MessageController {

        private KafkaProducer kafkaProducer ;

        public MessageController(KafkaProducer kafkaProducer) {
            this.kafkaProducer = kafkaProducer;
        }
        //http:localhost:8090/api/v1/kafka/publish?message=hello word
        @GetMapping("/publish")
        //định nghĩa một yêu cầu GET
        public ResponseEntity<String> publish(@RequestParam("message")  String message){
            kafkaProducer.sendMessage(message);
            //goi phuong thuc sendMessage trong kafakProducer để gửi tin nhắn đến Kafka
            return ResponseEntity.ok("Message sent to the topic!");
            //gửi tin nhắn  đã được gửi tới topic
        }
    }
