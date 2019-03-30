package com.lcydream.project.springcloudzuuldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author LuoCY
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient //is equest to @EnableEurekaClient
public class SpringCloudZuulDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulDemoApplication.class, args);
	}

}

