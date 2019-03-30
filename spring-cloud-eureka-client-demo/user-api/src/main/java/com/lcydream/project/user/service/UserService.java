package com.lcydream.project.user.service;

import com.lcydream.project.user.domain.User;

import java.util.Collection;

/**
 * UserService
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/13 21:59
 */
public interface UserService {

	/**
	 * 保存用户
	 *
	 * @param user 用户实体对象
	 * @return 如果保存成功的话，返回<code>true</code>,否则返回<code>false</code>
	 */
	boolean save(User user);

	/**
	 * 查询所有的用户信息
	 *
	 * @return 不会返回 <code>null</code>
	 */
	Collection<User> findAll();
}
