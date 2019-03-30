package com.lcydream.project.springcloudstreamkafkademo.raw.api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * KafkaProducerDemo
 * Kafka Producer Demo(使用原始API)
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/31 10:22
 */
public class KafkaProducerDemo {

  public static void main(String[] args) {
  	  //初始化配置信息
	  Properties properties = new Properties();
	  properties.setProperty("bootstrap.servers","192.168.21.160:9092");
	  properties.setProperty("key.serializer", StringSerializer.class.getName());
	  properties.setProperty("value.serializer",StringSerializer.class.getName());
	  //创建一个kafka Producer
	  KafkaProducer<String,String> kafkaProducer =
			  new KafkaProducer(properties);
	  //发送kafka消息
	  String topic="magic";
	  Integer partition=0;
	  Long timestamp=System.currentTimeMillis();
	  String key="message-key";
	  String value="luochunyun";
	  ProducerRecord<String,String> producerRecord =
			  new ProducerRecord<String,String>(topic,partition,timestamp,key,value);
	  //发送
	  Future<RecordMetadata> sendFuture = kafkaProducer.send(producerRecord);

	  //获取异步信息
	  try {
		  sendFuture.get();
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  } catch (ExecutionException e) {
		  e.printStackTrace();
	  }
  }

}
