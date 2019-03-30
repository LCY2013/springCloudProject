package com.lcydream.project.service;

import com.lcydream.project.domain.Person;
import com.lcydream.project.hystrix.PersonServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * PersonService
 * {@link Person} 服务
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/23 10:33
 */
@FeignClient(value = "person-service",fallback = PersonServiceFallback.class) //服务提供方应用名称
public interface PersonService {

	/**
	 * 保存用户信息
	 * @param person {@link Person}
	 * @return 成功返回<code>true</code>,其他返回<code>false</code>
	 */
	@PostMapping(value = "/person/save")
	boolean save(@RequestBody Person person);

	/**
	 * 查询所有用户信息
	 * @return 成功返回所有Person，其他返回空集合
	 */
	@GetMapping(value = "/person/find/all")
	Collection<Person> findAll();
}
