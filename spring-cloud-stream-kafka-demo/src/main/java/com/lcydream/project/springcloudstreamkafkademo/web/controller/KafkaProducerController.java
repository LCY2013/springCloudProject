package com.lcydream.project.springcloudstreamkafkademo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * KafkaProducerController
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/1/1 11:23
 */
@RestController
public class KafkaProducerController {

	private final KafkaTemplate<String,String> kafkaTemplate;
    private final String topic;

	@Autowired
	public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate,
	                               @Value("${kafka.topic}") String topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@PostMapping("/message/send")
	public String sendMessage(@RequestParam String message){
		kafkaTemplate.send(topic,message);
        return "成功";
	}
}
