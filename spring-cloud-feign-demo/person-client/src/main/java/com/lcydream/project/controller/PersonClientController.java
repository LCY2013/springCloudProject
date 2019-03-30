package com.lcydream.project.controller;

import com.lcydream.project.domain.Person;
import com.lcydream.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * PersonClientController
 * {@link PersonClientController} 实现 {@link PersonService}
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/23 10:54
 */
@RestController
public class PersonClientController implements PersonService{

	private final PersonService personService;

	@Autowired
	public PersonClientController(PersonService personService) {
		this.personService = personService;
	}

	@Override
	public boolean save(@RequestBody Person person) {
		return personService.save(person);
	}

	@Override
	public Collection<Person> findAll() {
		return personService.findAll();
	}
}
