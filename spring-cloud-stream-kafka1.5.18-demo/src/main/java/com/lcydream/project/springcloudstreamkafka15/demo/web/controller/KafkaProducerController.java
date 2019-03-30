package com.lcydream.project.springcloudstreamkafka15.demo.web.controller;

import com.lcydream.project.springcloudstreamkafka15.demo.stream.producer.MessageProducerBean;
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
    private final MessageProducerBean messageProducerBean;

	@Autowired
	public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate,
	                               @Value("${kafka.topic}") String topic,
	                               MessageProducerBean messageProducerBean) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
		this.messageProducerBean = messageProducerBean;
	}

	/**
	 * 通过{@link KafkaTemplate}发送消息
	 * @param message 消息内容
	 * @return 返回信息
	 */
	@PostMapping("/message/kafka/send")
	public String sendMessage(@RequestParam String message){
		kafkaTemplate.send(topic,message);
        return "成功";
	}

	/**
	 * 通过{@link MessageProducerBean}发送消息
	 * @param message 消息内容
	 * @return 返回信息
	 */
	@PostMapping("/message/stream/send")
	public String sendMessageByMessageProducerBean(@RequestParam String message){
		messageProducerBean.sendMessage(message);
        return "成功";
	}

	/**
	 * 通过{@link MessageProducerBean}发送消息
	 * @param message 消息内容
	 * @return 返回信息
	 */
	@PostMapping("/message/stream/test/send")
	public String sendMessageByMagic(@RequestParam String message){
		messageProducerBean.sendMessageTest(message);
        return "成功";
	}
}
