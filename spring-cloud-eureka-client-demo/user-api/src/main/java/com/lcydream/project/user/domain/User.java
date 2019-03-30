package com.lcydream.project.user.domain;

/**
 * User
 * 用户model，领域模型
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/13 21:59
 */
public class User {

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
