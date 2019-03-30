package com.lcydream.project.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * MyRule
 * 自定义实现{@link com.netflix.loadbalancer.IRule}
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/25 21:16
 */
public class FirstServerChooseRule extends AbstractLoadBalancerRule {

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {

	}

	@Override
	public Server choose(Object key) {
		final ILoadBalancer loadBalancer = getLoadBalancer();
		List<Server> allServers = loadBalancer.getAllServers();
		return allServers.get(0);
	}
}
