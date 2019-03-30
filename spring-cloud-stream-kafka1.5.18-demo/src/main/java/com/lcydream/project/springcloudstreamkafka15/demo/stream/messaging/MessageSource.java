package com.lcydream.project.springcloudstreamkafka15.demo.stream.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * MessageSource
 * 自定义管道消息源
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/1/2 16:31
 */
public interface MessageSource {

	/**
	 * 消息管道名称
	 */
	String NAME = "magic";

	@Output(NAME)
	MessageChannel magic();
}
