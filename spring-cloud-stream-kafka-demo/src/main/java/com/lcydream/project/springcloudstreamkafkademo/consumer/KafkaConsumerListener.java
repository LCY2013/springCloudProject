package com.lcydream.project.springcloudstreamkafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * KafkaConsumerListener Kafka消费者监听器
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/1/1 11:34
 */
@Component
public class KafkaConsumerListener {

  @KafkaListener(topics = "${kafka.topic}")
  public void processMessage(String message) {
    System.out.println("Kafka 消费者监听器接受到的数据:"+message);
  }
}
