package com.lcydream.project.user.web.controller;

import com.lcydream.project.user.domain.User;
import com.lcydream.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * UserController
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/13 22:05
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 保存用户信息
	 *
	 * @param user 请求参数名为"name"的数据
	 * @return 如果保存成功，返回{@link User}，否则返回<code>null</code>
	 */
	@PostMapping("/user/save")
	public User saveUser(@RequestBody User user){
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
		return userService.findAll();
	}

}
