package com.lcydream.project.service;

import com.lcydream.project.entity.Person;
import com.lcydream.project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * PersonService
 *  {@link com.lcydream.project.entity.Person}服务
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/1/6 15:27
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PersonService {

	/**
	 * 注入用户仓储
	 */
	@Autowired
	private PersonRepository personRepository;

	/**
	 * 通过标准的JPA方式注入
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 存储{@link Person}
	 * @param person person对象
	 */
	public void save(Person person){
		entityManager.persist(person);
		//personRepository.save(person);
	}

	public Page<Person> findAll(Pageable pageable){
		return personRepository.findAll(pageable);
	}
}
