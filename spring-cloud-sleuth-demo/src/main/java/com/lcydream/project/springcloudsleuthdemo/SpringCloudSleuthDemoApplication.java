package com.lcydream.project.springcloudsleuthdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author LuoCY
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudSleuthDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSleuthDemoApplication.class, args);
	}

	/**
	 * 生成一个RestTemplate
	 * @return template
	 */
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}

