package com.lcydream.project.springcloudzipkinserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @author LuoCY
 */
@SpringBootApplication
@EnableZipkinServer
public class SpringCloudZipkinServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinServerDemoApplication.class, args);
	}

}

