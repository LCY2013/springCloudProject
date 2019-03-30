package com.lcydream.project.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

/**
 * EchoEnvController
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/4 21:42
 */
@RestController
public class EchoEnvController {

	private final Environment environment;


	@Autowired
	public EchoEnvController(Environment environment) {
		this.environment = environment;
	}

	@GetMapping("/echoEnvironment/{name}")
	public Map<String,Object> echoEnvironment(@PathVariable("name")String name){
		Map<String,Object> map = new HashMap<>(2);
		map.put(name,environment.getProperty(name));
		return map;
	}
}
