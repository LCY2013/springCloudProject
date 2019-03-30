package com.lcydream.project.hystrix;


import com.lcydream.project.domain.Person;
import com.lcydream.project.service.PersonService;

import java.util.Collection;
import java.util.Collections;

/**
 * PersonServiceFallback
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/27 16:27
 */
public class PersonServiceFallback implements PersonService {

	@Override
	public boolean save(Person person) {
		return false;
	}

	@Override
	public Collection<Person> findAll() {
    return Collections.emptyList();
	}
}
