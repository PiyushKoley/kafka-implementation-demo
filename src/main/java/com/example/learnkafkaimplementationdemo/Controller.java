package com.example.learnkafkaimplementationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Value("${topic-value}")  // ******* WE HAVE TO INITIALISE THIS CONSTANT VALUE IN APPLICATION.PROPERTIES **********
    String topic;

    @PostMapping("/produce")
    public void createMessage(@RequestParam("msg") String message) {

        kafkaTemplate.send(topic,message);
    }
}
