package com.lcydream.project.entity;

import javax.persistence.*;

/**
 * Person 实体对象
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/1/6 15:03
 */
@Entity
@Table(name = "persons")
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	@Column(columnDefinition = "VARCHAR(128) NOT NULL")
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
}
