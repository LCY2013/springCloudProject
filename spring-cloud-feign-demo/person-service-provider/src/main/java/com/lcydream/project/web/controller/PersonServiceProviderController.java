package com.lcydream.project.web.controller;

import com.lcydream.project.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lcydream.project.service.PersonService;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * PersonServiceProviderController
 * {@link PersonService} 用户服务提供者控制器,可以实现{@link PersonService}也可以不实现
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/23 11:14
 */
@RestController
public class PersonServiceProviderController {

	private Map<Long,Person> persons = new ConcurrentHashMap<>();

	@Autowired
	private PersonService personService;

	private final static Random random = new Random();

	/**
	 * 保存用户信息
	 * @param person {@link Person}
	 * @return 成功返回<code>true</code>,其他返回<code>false</code>
	 */
	@PostMapping(value = "/person/save")
	@HystrixCommand(defaultFallback = "savePersonFallback",
			commandProperties = {
			@HystrixProperty(
					name = "execution.isolation.thread.timeoutInMilliseconds",
					value = "100")
	}
	)
	public boolean savePerson(@RequestBody Person person){
		int randomInt = random.nextInt(200);

		try {
			//TimeUnit.MILLISECONDS.sleep(randomInt);
			Thread.sleep(randomInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("[ThreadSavePerson-%s],%d ,%d\n",Thread.currentThread().getName(),System.currentTimeMillis(),randomInt);

		//return persons.putIfAbsent(person.getId(),person)==null;
		com.lcydream.project.entity.Person personOne =
				new com.lcydream.project.entity.Person();
		BeanUtils.copyProperties(person,personOne);
		personService.save(personOne);
		return true;
	}

	@GetMapping("/find/all")
	public Page<com.lcydream.project.entity.Person> findAll(Pageable pageable){
		return personService.findAll(pageable);
	}

	public boolean savePersonFallback(){
		return false;
	}

	/**
	 * 查询所有用户信息
	 * @return 成功返回所有Person，其他返回空集合
	 */
	@GetMapping(value = "/person/find/all")
	@HystrixCommand(fallbackMethod = "findAllPersonsFallBack",
			commandProperties = {
			@HystrixProperty(
					name = "execution.isolation.thread.timeoutInMilliseconds",
					value = "100")
	}
	)
	Collection<Person> findAllPersons(){
		int randomInt = random.nextInt(200);

		try {
			//TimeUnit.MILLISECONDS.sleep(randomInt);
			Thread.sleep(randomInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("[ThreadFindAllPersons-%s],%d ,%d\n",Thread.currentThread().getName(),System.currentTimeMillis(),randomInt);
		return persons.values();
	}

	public Collection<Person> findAllPersonsFallBack(){
		return Collections.emptyList();
	}
}
