package com.lcydream.project.springbootcoluddemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 * 欢迎页控制器
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/4 16:04
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "hello word";
	}
}
