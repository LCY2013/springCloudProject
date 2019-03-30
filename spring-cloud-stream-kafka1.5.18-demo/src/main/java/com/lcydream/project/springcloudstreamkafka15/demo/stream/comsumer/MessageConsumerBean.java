package com.lcydream.project.springcloudstreamkafka15.demo.stream.comsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * MessageConsumerBean
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/1/2 21:12
 */
@Component
@EnableBinding(Sink.class)
public class MessageConsumerBean {

  @Autowired
  @Qualifier(Sink.INPUT)
  private SubscribableChannel subscribableChannel;

  @Autowired private Sink sink;

  /** 当字段注入完成后的回调 */
  @PostConstruct
  public void init() {
    // 实现异步回调
    subscribableChannel.subscribe(
        (message) -> {
          System.out.println("subscribableChannel:" + message.getHeaders());
          System.out.println("subscribableChannel:" + message.getPayload());
        });
  }

  /**
   * {@link ServiceActivator }
   *
   * @param message 消息内容
   */
  @ServiceActivator(inputChannel = Sink.INPUT)
  public void onMessage(Object message) {
    System.out.println("@ServiceActivator：" + message);
  }

  @StreamListener(Sink.INPUT)
  public void onMessageListener(Object message) {
    System.out.println("@StreamListener：" + message);
  }
}
