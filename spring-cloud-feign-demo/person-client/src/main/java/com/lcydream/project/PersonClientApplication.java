package com.lcydream.project;

import com.lcydream.project.ribbon.FirstServerChooseRule;
import com.lcydream.project.service.PersonService;
import com.lcydream.project.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * PersonClientApplication
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/23 10:52
 */
@SpringBootApplication
@EnableFeignClients(clients = {PersonService.class})
@EnableEurekaClient
@EnableHystrix
//@RibbonClient(value = "person-service",configuration = {PersonClientApplication.class})
@Import(WebConfig.class)
public class PersonClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(PersonClientApplication.class, args);
  }

  @Bean
  public FirstServerChooseRule firstServerChooseRule(){
    return new FirstServerChooseRule();
  }
}
