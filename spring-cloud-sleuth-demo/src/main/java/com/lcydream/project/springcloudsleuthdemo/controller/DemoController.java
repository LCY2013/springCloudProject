package com.lcydream.project.springcloudsleuthdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * DemoController
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/1/5 10:14
 */
@RestController
public class DemoController {

	protected final Logger logger = LoggerFactory.getLogger(DemoController.class);

	private final RestTemplate restTemplate;

	@Autowired
	public DemoController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/index")
	public String index(){
		String returnValue = "Hello,magic";
		logger.info("{} index() : {}",getClass().getSimpleName(),returnValue);
		return returnValue;
	}

	/**
	 * 调用链路
	 * spring-cloud-sleuth
	 * -> zuul
	 * -> person-client
	 * -> person-service
	 * @return
	 */
	@GetMapping("/to/zuul/person-client/person/find/all")
	public Object toZuul(){
		logger.info("{} spring-cloud-sleuth#zuul",getClass().getSimpleName());
		String url = "http://spring-cloud-zuul/person-client/person/find/all";
		return restTemplate.getForObject(
				url,Object.class);
	}
}
