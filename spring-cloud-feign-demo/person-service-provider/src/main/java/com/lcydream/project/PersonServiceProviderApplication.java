package com.lcydream.project;

import com.lcydream.project.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * PersonServiceProviderApplication
 * {@link com.lcydream.project.service.PersonService} 服务提供者
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/23 11:11
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@Import(WebConfig.class)
@EnableTransactionManagement(proxyTargetClass = true)
public class PersonServiceProviderApplication {

  public static void main(String[] args) {
	  SpringApplication.run(PersonServiceProviderApplication.class,args);
  }
}
