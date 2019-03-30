package com.lcydream.project.rabbitmq.demo.stream.producer;

import com.lcydream.project.rabbitmq.demo.stream.messaging.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * MessageProducerBean
 * 消息生产者
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/1/2 15:13
 */
@Component
@EnableBinding({Source.class,MessageSource.class})
public class MessageProducerBean {

	@Autowired
	@Qualifier(Source.OUTPUT)
	private MessageChannel messageChannel;

	@Autowired
	private Source source;

	@Autowired
	@Qualifier(MessageSource.NAME)
	private MessageChannel magicMessageChannel;

	@Autowired
	private MessageSource messageSource;

	/**
	 * 发送消息
	 * @param message 消息内容
	 */
	public void sendMessage(String message){
		//通过消息管道发送消息
		//messageChannel.send(MessageBuilder.withPayload(message).build());
		source.output().send(MessageBuilder.withPayload(message).build());
	}

	/**
	 * 发送消息到Test
	 * @param message 消息内容
	 */
	public void sendMessageTest(String message){
		//通过消息管道发送消息
		magicMessageChannel.send(MessageBuilder.withPayload(message).build());
	}
}
