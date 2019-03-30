package com.lcydream.project.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * UserServiceConsumerBootstrap
 * {@link com.lcydream.project.user.service.UserService 用户服务} 消费引导类
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/14 15:43
 */
@SpringBootApplication
@EnableDiscoveryClient
@Configuration
public class UserServiceConsumerBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceConsumerBootstrap.class,args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
