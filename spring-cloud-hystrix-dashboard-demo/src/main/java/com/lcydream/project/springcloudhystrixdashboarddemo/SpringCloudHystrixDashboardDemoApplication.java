package com.lcydream.project.springcloudhystrixdashboarddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringCloudHystrixDashboardDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixDashboardDemoApplication.class, args);
	}

}

