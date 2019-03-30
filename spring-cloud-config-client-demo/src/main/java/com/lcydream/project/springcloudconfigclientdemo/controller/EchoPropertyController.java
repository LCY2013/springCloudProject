package com.lcydream.project.springcloudconfigclientdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EchoPropertyController
 *
 * @author Luo Chun Yun
 * @Email 1475653689@qq.com
 * @date 2018/12/7 14:38
 */
@RestController
@RefreshScope
public class EchoPropertyController {

	@Value("${my.name}")
	private String myName;

	@GetMapping("/echoProperty")
	public Object echoProperty(){
		return myName;
	}
}
