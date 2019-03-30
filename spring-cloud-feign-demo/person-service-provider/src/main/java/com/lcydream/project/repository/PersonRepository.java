package com.lcydream.project.repository;

import com.lcydream.project.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * PersonRepository 用户仓储
 * {@link Person}
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/1/6 16:55
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person,Long> {
}
