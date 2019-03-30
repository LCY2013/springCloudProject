package com.lcydream.project.user.web.controller;

import com.lcydream.project.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.lcydream.project.user.service.UserService;

import java.util.Collection;

/**
 * UserServiceProviderRestApiController
 * {@link UserService 用户服务} 提供方 REST API {@link RestController}
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/14 11:38
 */
@RestController
public class UserServiceProviderRestApiController {

	@Autowired
	private UserService userService;

	@Value("${server.port}")
	private String port;

	/**
	 * 保存用户信息
	 *
	 * @param user 用户信息
	 * @return 如果保存成功，返回{@link User}，否则返回<code>null</code>
	 */
	@PostMapping("/user/save")
	public User saveUser(@RequestBody User user){
		System.out.println(port + ":" + user);
		if(userService.save(user)){
			return user;
		}else {
			return null;
		}
	}

	/**
	 * 获取所有的用户信息
	 *
	 * @return 返回所有用户信息
	 */
	@GetMapping("/user/list")
	public Collection<User> list(){
		System.out.println(port + ":list");
		return userService.findAll();
	}

}
