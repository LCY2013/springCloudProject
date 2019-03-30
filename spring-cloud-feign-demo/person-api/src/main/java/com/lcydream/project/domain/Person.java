package com.lcydream.project.domain;

import lombok.Data;

/**
 * Person
 * 人的模型
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/23 10:28
 */
@Data
public class Person {

	private Long id;

	private String name;

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
