package com.lcydream.project.user.repository;

import com.lcydream.project.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * UserRepository
 * {@link User 用户} 用户仓储
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/14 11:57
 */
@Repository
public class UserRepository {

	/**
	 * 缓存用户信息
	 */
	private static ConcurrentMap<Long,User> userList = new ConcurrentHashMap<>();

	/**
	 * ID生成器
	 */
	private static final AtomicLong atomicLong = new AtomicLong(0);

	/**
	 * 保存用户信息
	 *
	 * @param user 用户信息
	 * @return 返回时候保存成功
	 */
	public boolean save(User user) {
		user.setId(atomicLong.incrementAndGet());
		return userList.putIfAbsent(user.getId(),user)==null;
	}

	/**
	 * 查询所有的用户信息
	 *
	 * @return 返回用户集合信息
	 */
	public Collection<User> findAll() {
		return userList.values();
	}

  public static void main(String[] args) {
	  ConcurrentMap<Long,String> list = new ConcurrentHashMap<>(3);
	  System.out.println(list.putIfAbsent(1L,"1"));
      System.out.println(list.putIfAbsent(1L,"1"));
      System.out.println(list.putIfAbsent(1L,"1"));
  }
}
