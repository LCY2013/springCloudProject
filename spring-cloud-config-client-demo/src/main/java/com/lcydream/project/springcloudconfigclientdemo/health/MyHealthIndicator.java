package com.lcydream.project.springcloudconfigclientdemo.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

/**
 * MyHealthIndicator
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/10 20:48
 */
public class MyHealthIndicator extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {
		//builder.up().withDetail("MyHealthIndicator","is's good");
		//一个配置down整个服务就down
		builder.down().withDetail("MyHealthIndicator","is's bad");
	}
}
