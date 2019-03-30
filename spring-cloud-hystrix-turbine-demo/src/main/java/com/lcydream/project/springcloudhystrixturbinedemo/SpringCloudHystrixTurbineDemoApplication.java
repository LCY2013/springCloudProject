package com.lcydream.project.springcloudhystrixturbinedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class SpringCloudHystrixTurbineDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixTurbineDemoApplication.class, args);
	}

}

