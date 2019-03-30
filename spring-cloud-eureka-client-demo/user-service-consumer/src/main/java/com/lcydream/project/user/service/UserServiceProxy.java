package com.lcydream.project.user.service;

import com.lcydream.project.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * UserServiceProxy
 * {@link UserService 用户服务}服务代理
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/14 15:22
 */
@Service
public class UserServiceProxy implements UserService {

	/**
	 * 调用用户提供服务的前缀
	 */
	private static final String PRIVEDOR_SERVER_URL_PREFIX="http://user-service-provider";

	/**
	 * 通过REST API代理到服务器提供者
	 */
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean save(User user) {
		User returnValue = restTemplate.postForObject(
				PRIVEDOR_SERVER_URL_PREFIX + "/user/save", user, User.class);
		return returnValue != null;
	}

	@Override
	public Collection<User> findAll() {
		return restTemplate.getForObject(PRIVEDOR_SERVER_URL_PREFIX+"/user/list",Collection.class);
	}
}
