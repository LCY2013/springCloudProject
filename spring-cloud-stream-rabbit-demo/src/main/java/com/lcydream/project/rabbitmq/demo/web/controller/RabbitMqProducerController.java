package com.lcydream.project.rabbitmq.demo.web.controller;

import com.lcydream.project.rabbitmq.demo.stream.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RabbitMqProducerController
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/1/1 11:23
 */
@RestController
public class RabbitMqProducerController {

    private final String topic;
    private final MessageProducerBean messageProducerBean;

	@Autowired
	public RabbitMqProducerController(@Value("${rabbitmq.topic}") String topic,
	                                  MessageProducerBean messageProducerBean) {
		this.topic = topic;
		this.messageProducerBean = messageProducerBean;
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
