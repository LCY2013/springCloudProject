package com.lcydream.project.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * UserServiceProviderBootstrap
 * {@link com.lcydream.project.user.service.UserService 用户服务} 提供引导类
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/14 14:56
 */
//@SpringCloudApplication
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceProviderBootstrap {

  public static void main(String[] args) {
	  SpringApplication.run(UserServiceProviderBootstrap.class,args);
  }

}
