package com.lcydream.project.springcloudconfigserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/** @author LuoCY */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class SpringCloudConfigServerDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudConfigServerDemoApplication.class, args);
  }

}
