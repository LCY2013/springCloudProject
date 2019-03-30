package com.lcydream.project.user.service;

import com.lcydream.project.user.domain.User;
import com.lcydream.project.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * UserServiceImpl
 * {@link UserService 用户服务}提供者服务
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/14 11:54
 */
@Service
public class UserServiceImpl implements UserService{

	/**
	 * 用户仓储
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * 保存用户信息
	 *
	 * @param user 用户实体对象
	 * @return 返回时候成功
	 */
	@Override
	public boolean save(User user) {
		return userRepository.save(user);
	}

	/**
	 * 查询所有用户信息
	 *
	 * @return 返回用户集合
	 */
	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}
}
