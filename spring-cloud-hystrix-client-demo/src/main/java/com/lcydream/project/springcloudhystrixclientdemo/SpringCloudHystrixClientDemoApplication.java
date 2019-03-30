package com.lcydream.project.springcloudhystrixclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@EnableHystrix
@EnableCircuitBreaker
@EnableTurbine
@PropertySource(value = {"config.properties"})
public class SpringCloudHystrixClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixClientDemoApplication.class, args);
	}

}

